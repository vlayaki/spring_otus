package ru.otus.homework2.service;

import ru.otus.homework2.pojo.UserInfo;

import java.util.Map;

public interface PrintService {
    String getPrintResultsAsString(UserInfo userInfo, Map<String, String> questionsToAnswers);
}
