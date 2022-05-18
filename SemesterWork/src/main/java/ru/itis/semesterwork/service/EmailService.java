package ru.itis.semesterwork.service;

import ru.itis.semesterwork.dto.request.LoginRequest;
import ru.itis.semesterwork.dto.response.UserResponse;

public interface EmailService {

    UserResponse confirmEmail(String confirmCode);

    void createCode(LoginRequest loginRequest);
}
