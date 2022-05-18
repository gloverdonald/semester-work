package ru.itis.semesterwork.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.itis.semesterwork.dto.response.UserResponse;
import ru.itis.semesterwork.exceptions.UserNotFoundException;
import ru.itis.semesterwork.mapper.UserMapper;
import ru.itis.semesterwork.repository.UserRepository;
import ru.itis.semesterwork.service.TokenAuthorizationService;

@RequiredArgsConstructor
@Service
public class TokenAuthorizationServiceImpl implements TokenAuthorizationService {

    @Value("${secret}")
    private String secretKey;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse getUserInfoByToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token).getBody();
        String email = claims.getSubject();
        return userMapper.toResponse(userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new));
    }
}
