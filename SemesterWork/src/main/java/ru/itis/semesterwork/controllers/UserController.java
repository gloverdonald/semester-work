package ru.itis.semesterwork.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.semesterwork.dto.request.LoginRequest;
import ru.itis.semesterwork.dto.request.RegistrationRequest;
import ru.itis.semesterwork.dto.request.TokenRefreshRequest;
import ru.itis.semesterwork.dto.response.TokensResponse;
import ru.itis.semesterwork.dto.response.UserResponse;
import ru.itis.semesterwork.service.EmailService;
import ru.itis.semesterwork.service.TokenService;
import ru.itis.semesterwork.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final TokenService tokenService;
    private final EmailService emailService;

    @PostMapping("/sign-up")
    public Long create(@Valid @RequestBody RegistrationRequest registrationRequest) {
        return userService.create(registrationRequest);
    }

    @PostMapping(value = "/sign-in")
    public TokensResponse login(@RequestBody LoginRequest userRequest) {
        return tokenService.generateTokens(userService.login(userRequest));
    }

    @PostMapping("/refresh")
    public TokensResponse refresh(@RequestBody TokenRefreshRequest request) {
        return tokenService.refreshTokens(request);
    }

    @GetMapping("/{id}")
    private UserResponse get(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/all")
    private List<UserResponse> getAll() {
        return userService.getAll();
    }

    @GetMapping("/confirm/{confirm-code}")
    public UserResponse sendConfirmationCode(@PathVariable("confirm-code") String confirmCode) {
        return emailService.confirmEmail(confirmCode);
    }

    @PostMapping("/confirm")
    public void sendConfirmationCode(@RequestBody LoginRequest loginRequest) {
        emailService.createCode(loginRequest);
    }
}
