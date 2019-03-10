package ru.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageSource messageSource;
    private final LocaleService localeService;

    @Override
    public String getMessage(String s) {
        return messageSource.getMessage(s, null, localeService.getUserLocale());
    }

    @Override
    public String getMessage(String s, Object... args) {
        return messageSource.getMessage(s, args, localeService.getUserLocale());
    }
}
