package com.github.computerhuis.dhwco.config;

import com.github.computerhuis.dhwco.filter.LogFilter;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityApplicationConfiguration {

    private static final String
        QUERY_USERNAME = "SELECT persoon_nr, wachtwoord_hash, CASE WHEN uitschrijf_datum IS NULL THEN 'true' ELSE 'false' END AS enabled FROM gebruikers WHERE naam=?";
    private static final String
        QUERY_AUTHORITIES = "SELECT persoon_nr AS id, rol AS authority FROM gebruiker_rollen WHERE persoon_nr=?";

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsManager users(final DataSource dataSource) {
        val jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(QUERY_USERNAME);
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(QUERY_AUTHORITIES);
        return jdbcUserDetailsManager;
    }

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/assets", "/assets/**", "/favicon.ico");
    }

    @Bean
    SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
        // Add log filter
        http.addFilterBefore(new LogFilter(), WebAsyncManagerIntegrationFilter.class);

        // Enable Content Security Policy
        http.headers(headers -> headers.contentSecurityPolicy(contentSecurityPolicy ->
                contentSecurityPolicy.policyDirectives("default-src 'self'; img-src 'self' data:")
            )
        );

        http.authorizeHttpRequests()
            .requestMatchers("/inloggen")
            .permitAll()
            .anyRequest()
            .authenticated();

        // login
        http.formLogin()
            .loginPage("/inloggen")
            .defaultSuccessUrl("/");

        // Logout
        http.logout()
            .logoutUrl("/uitloggen")
            .logoutSuccessUrl("/inloggen")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID");


        return http.build();
    }
}
