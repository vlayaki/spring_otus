package ru.otus.homework1.service;

import java.util.Map;

public interface PrintService {
    void printQuizResults(String firstName, String lastName, Map<String, String> questionsToAnswers);
}
