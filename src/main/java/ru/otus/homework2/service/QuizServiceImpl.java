package ru.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework2.dao.QuizDao;

import java.util.*;

@Service
@RequiredArgsConstructor
@Log4j
public class QuizServiceImpl implements QuizService {
    private static final Scanner scanner = new Scanner(System.in);

    private final QuizDao quizDao;
    private final PrintService printService;
    private final MessageSource messageSource;
    private final LocaleService localeService;

    @Override
    public void startQuiz() {
        Locale userLocale = localeService.getUserLocale();
        log.info(messageSource.getMessage("msg.name.first", null, userLocale));
        String firstName = scanner.nextLine();
        log.info(messageSource.getMessage("msg.name.last", null, userLocale));
        String lastName = scanner.nextLine();
        log.info(messageSource.getMessage("msg.answer.questions", null, userLocale));
        List<String> questions = quizDao.getQuestions();
        Map<String, String> questionsToAnswers = new LinkedHashMap<>();
        for (String question : questions) {
            log.info(question);
            questionsToAnswers.put(question, scanner.nextLine());
        }
        log.info(printService.getPrintResultsAsString(firstName, lastName, questionsToAnswers));
    }


}
