package ru.otus.hw2;

import org.junit.Test;
import ru.otus.homework2.dao.CsvQuizDao;
import ru.otus.homework2.dao.QuizDao;

import java.util.List;
import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class CsvQuizDaoTest {

    @Test
    public void shouldReturnQuestionsInEnglishForUsersWithEnglishLocale() {
        QuizDao quizDao = new CsvQuizDao();
        List<String> questions = quizDao.getQuestions(Locale.ENGLISH);
        assertThat(questions, contains("How old are you?", "Do you have any pets?", "What is your favorite color?"));
    }

    @Test
    public void shouldReturnQuestionsInRussianForUsersWithRussianLocale(){
        QuizDao quizDao = new CsvQuizDao();
        List<String> questions = quizDao.getQuestions(new Locale("ru"));
        assertThat(questions, contains("Сколько Вам лет?", "У Вас есть домашние животные?", "Какой Ваш любимый цвет?"));
    }

}

