package ru.itis.semesterwork.service;

import ru.itis.semesterwork.dto.request.TokenRefreshRequest;
import ru.itis.semesterwork.dto.response.TokensResponse;
import ru.itis.semesterwork.dto.response.UserResponse;

public interface TokenService {
    TokensResponse generateTokens(UserResponse userResponse);

    TokensResponse refreshTokens(TokenRefreshRequest request);
}
