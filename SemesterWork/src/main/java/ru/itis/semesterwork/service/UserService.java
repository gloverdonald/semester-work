package ru.itis.semesterwork.service;

import ru.itis.semesterwork.dto.request.LoginRequest;
import ru.itis.semesterwork.dto.request.RegistrationRequest;
import ru.itis.semesterwork.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    Long create(RegistrationRequest userRequest);

    UserResponse login(LoginRequest loginRequest);

    UserResponse getById(Long id);

    List<UserResponse> getAll();
}
