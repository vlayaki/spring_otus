package ru.otus.homework1;

import lombok.extern.log4j.Log4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.homework1.service.QuizService;

@Log4j
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuizService quizService = context.getBean(QuizService.class);
        quizService.startQuiz();
    }
}
