package ru.otus.homework2.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import ru.otus.homework2.service.LocaleService;

import java.util.Arrays;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PropertiesQuizDao implements QuizDao {

    private final MessageSource messageSource;
    private final LocaleService localeService;

    @Override
    public List<String> getQuestions() {
        return Arrays.asList(messageSource.getMessage("quiz.questions", null, localeService.getUserLocale()).split(","));
    }
}
