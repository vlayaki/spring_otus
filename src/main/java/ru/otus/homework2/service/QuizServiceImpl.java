package ru.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import ru.otus.homework2.dao.QuizDao;
import ru.otus.homework2.pojo.UserInfo;

import java.util.*;

@Service
@RequiredArgsConstructor
@Log4j
public class QuizServiceImpl implements QuizService {
    private static final Scanner scanner = new Scanner(System.in);

    private final QuizDao quizDao;
    private final PrintService printService;
    private final MessageService messageService;
    private final LocaleService localeService;

    @Override
    public void startQuiz() {
        Locale userLocale = localeService.getUserLocale();
        UserInfo userInfo = collectUserInfo();
        Map<String, String> questionsToAnswers = conductQuiz(userLocale);
        log.info(printService.getPrintResultsAsString(userInfo, questionsToAnswers));
    }

    private UserInfo collectUserInfo(){
        log.info(messageService.getMessage("msg.name.first"));
        String firstName = scanner.nextLine();
        log.info(messageService.getMessage("msg.name.last"));
        String lastName = scanner.nextLine();
        return new UserInfo(firstName, lastName);
    }

    private Map<String, String> conductQuiz(Locale userLocale){
        log.info(messageService.getMessage("msg.answer.questions"));
        List<String> questions = quizDao.getQuestions(userLocale);
        Map<String, String> questionsToAnswers = new LinkedHashMap<>();
        for (String question : questions) {
            log.info(question);
            questionsToAnswers.put(question, scanner.nextLine());
        }
        return questionsToAnswers;
    }
}
