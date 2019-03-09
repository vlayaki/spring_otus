package ru.otus.homework1.service;

import lombok.extern.log4j.Log4j;
import ru.otus.homework1.dao.QuizDao;

import java.util.*;

@Log4j
public class QuizServiceImpl implements QuizService {
    private static final Scanner scanner = new Scanner(System.in);

    private QuizDao quizDao;
    private PrintService printService;

    public QuizServiceImpl(QuizDao quizDao, PrintService printService) {
        this.quizDao = quizDao;
        this.printService = printService;
    }

    @Override
    public void startQuiz() {
        log.info("Please enter your first name.");
        String firstName = scanner.nextLine();
        log.info("Please enter your last name.");
        String lastName = scanner.nextLine();
        log.info("Please answer following questions: ");
        List<String> questions = quizDao.getQuestions();
        Map<String, String> questionsToAnswers = new LinkedHashMap<>();
        for (String question : questions) {
            log.info(question);
            questionsToAnswers.put(question, scanner.nextLine());
        }
        printService.printQuizResults(firstName, lastName, questionsToAnswers);
    }


}
