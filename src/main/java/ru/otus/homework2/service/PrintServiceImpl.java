package ru.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

@Service
@Log4j
@RequiredArgsConstructor
public class PrintServiceImpl implements PrintService {

    private final MessageSource messageSource;
    private final LocaleService localeService;

    @Override
    public String getPrintResultsAsString(String firstName, String lastName, Map<String, String> questionsToAnswers) {
        Locale userLocale = localeService.getUserLocale();
        String res = "=============================================================";
        res += System.lineSeparator();
        res += messageSource.getMessage("msg.results", new Object[]{firstName, lastName}, userLocale);
        res += System.lineSeparator();
        Set<Map.Entry<String, String>> answersSet = questionsToAnswers.entrySet();
        for (Map.Entry<String, String> entry : answersSet) {
            res += System.lineSeparator();
            res += messageSource.getMessage("msg.question", new Object[]{entry.getKey()}, userLocale);
            res += System.lineSeparator();
            res += messageSource.getMessage("msg.answer", new Object[]{entry.getValue()}, userLocale);
            res += System.lineSeparator();
        }
        res += "=============================================================";
        return res;
    }
}
