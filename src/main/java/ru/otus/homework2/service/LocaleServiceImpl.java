package ru.otus.homework2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LocaleServiceImpl implements LocaleService {

    private final Locale locale;

    public LocaleServiceImpl(@Value("${application.locale}") String locale) {
        this.locale = new Locale(locale);
    }

    @Override
    public Locale getUserLocale() {
        return this.locale;
    }
}
