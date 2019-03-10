package ru.otus.homework2.dao;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class CsvQuizDao implements QuizDao {

    private static final String FILE_PREFIX = "questions";

    @Override
    public List<String> getQuestions(Locale locale) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(buildFileName(locale)).getFile());
        try (CSVReader csvReader = new CSVReader(new FileReader(file))) {
            return csvReader.readAll().
                    stream().
                    map(line -> line[0]).
                    collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String buildFileName(Locale locale) {
        return FILE_PREFIX + "_" + locale.toString() + ".csv";
    }
}
