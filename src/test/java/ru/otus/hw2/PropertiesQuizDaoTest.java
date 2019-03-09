package ru.otus.hw2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.otus.homework2.dao.PropertiesQuizDao;
import ru.otus.homework2.dao.QuizDao;
import ru.otus.homework2.service.LocaleService;
import ru.otus.hw2.config.TestConfig;

import java.util.List;
import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class PropertiesQuizDaoTest {
    @Autowired
    MessageSource messageSource;

    @Test
    public void shouldReturnQuestionsInEnglishForUsersWithEnglishLocale() {
        LocaleService localeService = Mockito.mock(LocaleService.class);
        Mockito.when(localeService.getUserLocale()).thenReturn(Locale.ENGLISH);
        QuizDao quizDao = new PropertiesQuizDao(messageSource, localeService);
        List<String> questions = quizDao.getQuestions();
        assertThat(questions, contains("How old are you?", "Do you have any pets?", "What is your favorite color?"));
    }

    @Test
    public void shouldReturnQuestionsInRussianForUsersWithRussianLocale(){
        LocaleService localeService = Mockito.mock(LocaleService.class);
        Mockito.when(localeService.getUserLocale()).thenReturn(new Locale("ru"));
        QuizDao quizDao = new PropertiesQuizDao(messageSource, localeService);
        List<String> questions = quizDao.getQuestions();
        assertThat(questions, contains("Сколько Вам лет?", "У Вас есть домашние животные?", "Какой Ваш любимый цвет?"));
    }

}

