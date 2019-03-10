package ru.otus.homework2.service;

public interface MessageService {
    String getMessage(String s);

    String getMessage(String s, Object... args);
}
