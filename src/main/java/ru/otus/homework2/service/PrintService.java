package ru.otus.homework2.service;

import java.util.Map;

public interface PrintService {
    String getPrintResultsAsString(String firstName, String lastName, Map<String, String> questionsToAnswers);
}
