package ru.itis.semesterwork.dto.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    USER("Пользователь"),
    ADMIN("Администратор");

    private final String description;
}
