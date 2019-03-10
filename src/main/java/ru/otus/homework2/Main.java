package ru.otus.homework2;

import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.homework2.config.AppConfig;
import ru.otus.homework2.service.QuizService;

@Log4j
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        QuizService quizService = context.getBean(QuizService.class);
        quizService.startQuiz();
    }
}
