package com.github.computerhuis.dhwco.config;

import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
class ApplicationWebMvcConfigurer implements WebMvcConfigurer {

    private static final String DEFAULT_LANGUAGE = "nl";
    private static final String INTERCEPTOR_PARAM_NAME = "taal";
    private static final int CACHE_PERIOD = 3600;

    // --[ INTERCEPTORS ]-----------------------------------------------------------------------------------------------
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    // --[ RESOURCES ]--------------------------------------------------------------------------------------------------
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**")
            .addResourceLocations("classpath:/assets/")
            .setCachePeriod(CACHE_PERIOD);
        registry.addResourceHandler("/favicon.ico")
            .addResourceLocations("classpath:/assets/favicons/favicon.ico")
            .setCachePeriod(CACHE_PERIOD);
    }

    // --[ BEANS ]------------------------------------------------------------------------------------------------------
    @Bean
    public LocaleResolver localeResolver() {
        val localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.forLanguageTag(DEFAULT_LANGUAGE));
        return localeResolver;
    }

    @Bean
    public HandlerInterceptor localeChangeInterceptor() {
        val handlerInterceptor = new LocaleChangeInterceptor();
        handlerInterceptor.setParamName(INTERCEPTOR_PARAM_NAME);
        return handlerInterceptor;
    }
}
