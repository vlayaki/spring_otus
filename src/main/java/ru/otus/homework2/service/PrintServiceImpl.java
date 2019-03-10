package ru.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import ru.otus.homework2.pojo.UserInfo;

import java.util.Map;
import java.util.Set;

@Service
@Log4j
@RequiredArgsConstructor
public class PrintServiceImpl implements PrintService {

    private final MessageService messageService;

    @Override
    public String getPrintResultsAsString(UserInfo userInfo, Map<String, String> questionsToAnswers) {
        String res = "=============================================================";
        res += System.lineSeparator();
        res += messageService.getMessage("msg.results", userInfo.getFirstName(), userInfo.getLastName());
        res += System.lineSeparator();
        Set<Map.Entry<String, String>> answersSet = questionsToAnswers.entrySet();
        for (Map.Entry<String, String> entry : answersSet) {
            res += System.lineSeparator();
            res += messageService.getMessage("msg.question", entry.getKey());
            res += System.lineSeparator();
            res += messageService.getMessage("msg.answer", entry.getValue());
            res += System.lineSeparator();
        }
        res += "=============================================================";
        return res;
    }
}
