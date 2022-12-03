package com.github.computerhuis.dhwco.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class MessageSourceConfiguration {

    private static final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

    static {
        messageSource.setBasenames("classpath:/languages/messages");
    }

    // --[ GETTER ]-----------------------------------------------------------------------------------------------------
    public static String getLabel(final String key) {
        return getLabel(key, LocaleContextHolder.getLocale(), null);
    }

    public static String getLabel(final String key, final Object... args) {
        return getLabel(key, LocaleContextHolder.getLocale(), args);
    }

    public static String getLabel(final String key, final String language) {
        return getLabel(key, Locale.forLanguageTag(language), null);
    }

    public static String getLabel(final String key, final Locale locale) {
        return getLabel(key, locale, null);
    }

    public static String getLabel(final String key, final String language, final Object... args) {
        return getLabel(key, Locale.forLanguageTag(language), args);
    }

    public static String getLabel(final String key, final Locale locale, final Object... args) {
        return messageSource.getMessage(key, args, locale);
    }

    public static MessageSource getMessageSource() {
        return messageSource;
    }

    // --[ BEANS ]------------------------------------------------------------------------------------------------------
    @Bean
    public MessageSource messageSource() {
        return messageSource;
    }
}
