package ru.otus.hw2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.otus.homework2.service.LocaleService;
import ru.otus.homework2.service.PrintService;
import ru.otus.homework2.service.PrintServiceImpl;
import ru.otus.hw2.config.TestConfig;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class PrintServiceTest {

    @Autowired
    MessageSource messageSource;

    @Test
    public void shouldReturnQuizResultsInRussianForUsersWithRussianLocale() {
        LocaleService localeService = Mockito.mock(LocaleService.class);
        Mockito.when(localeService.getUserLocale()).thenReturn(new Locale("ru"));
        PrintService printService = new PrintServiceImpl(messageSource, localeService);
        Map<String, String> questionsToAnswers = new HashMap<>();
        questionsToAnswers.put("Сколько Вам лет?", "11");
        questionsToAnswers.put("Есть ли у Вас домашние животные?", "да");
        String quizResults = printService.getPrintResultsAsString("Иванов", "Иван", questionsToAnswers);
        String expected = "=============================================================" +
                System.lineSeparator() +
                "Результаты опроса для Иванов Иван:" +
                System.lineSeparator() +
                System.lineSeparator() +
                "вопрос: Сколько Вам лет?" +
                System.lineSeparator() +
                "ответ: 11" +
                System.lineSeparator() +
                System.lineSeparator() +
                "вопрос: Есть ли у Вас домашние животные?" +
                System.lineSeparator() +
                "ответ: да" +
                System.lineSeparator() +
                "=============================================================";
        assertThat(quizResults, equalTo(expected));
    }

    @Test
    public void shouldReturnQuizResultsInEnglishForUsersWithEnglishLocale() {
        LocaleService localeService = Mockito.mock(LocaleService.class);
        Mockito.when(localeService.getUserLocale()).thenReturn(Locale.ENGLISH);
        PrintService printService = new PrintServiceImpl(messageSource, localeService);
        Map<String, String> questionsToAnswers = new HashMap<>();
        questionsToAnswers.put("How old are you?", "11");
        questionsToAnswers.put("Do you have any pets?", "no");
        String quizResults = printService.getPrintResultsAsString("Ivan", "Ivanov", questionsToAnswers);
        String expected = "=============================================================" +
                System.lineSeparator() +
                "Quiz results for Ivan Ivanov:" +
                System.lineSeparator() +
                System.lineSeparator() +
                "question: How old are you?" +
                System.lineSeparator() +
                "answer: 11" +
                System.lineSeparator() +
                System.lineSeparator() +
                "question: Do you have any pets?" +
                System.lineSeparator() +
                "answer: no" +
                System.lineSeparator() +
                "=============================================================";
        assertThat(quizResults, equalTo(expected));
    }
}
