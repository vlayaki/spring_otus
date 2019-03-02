package ru.otus.homework1.service;

import lombok.extern.log4j.Log4j;

import java.util.Map;
import java.util.Set;

@Log4j
public class ConsolePrintService implements PrintService {

    @Override
    public void printQuizResults(String firstName, String lastName, Map<String, String> questionsToAnswers) {
        log.info("");
        log.info("=============================================================");
        log.info("Quiz results for " + firstName + " " + lastName + ":");
        Set<Map.Entry<String, String>> answersSet = questionsToAnswers.entrySet();
        for (Map.Entry<String, String> entry : answersSet) {
            log.info("");
            log.info("question: " + entry.getKey());
            log.info("answer: " + entry.getValue());
        }
        log.info("=============================================================");
    }
}
