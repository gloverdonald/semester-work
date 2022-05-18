package ru.itis.semesterwork.service;

import ru.itis.semesterwork.dto.response.UserResponse;

public interface TokenAuthorizationService {
    UserResponse getUserInfoByToken(String token);
}
