package ru.otus.homework2.pojo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserInfo {
    private final String firstName;
    private final String lastName;
}
