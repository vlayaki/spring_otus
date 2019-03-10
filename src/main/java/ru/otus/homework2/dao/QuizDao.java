package ru.otus.homework2.dao;

import java.util.List;
import java.util.Locale;

public interface QuizDao {
    List<String> getQuestions(Locale locale);
}
