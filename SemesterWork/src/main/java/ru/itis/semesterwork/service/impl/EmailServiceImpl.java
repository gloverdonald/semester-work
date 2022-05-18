package ru.itis.semesterwork.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.semesterwork.dto.request.LoginRequest;
import ru.itis.semesterwork.dto.response.UserResponse;
import ru.itis.semesterwork.exceptions.ConfirmCodeNotFoundException;
import ru.itis.semesterwork.exceptions.UnauthorizedException;
import ru.itis.semesterwork.mapper.UserMapper;
import ru.itis.semesterwork.models.ConfirmCodeEntity;
import ru.itis.semesterwork.models.UserEntity;
import ru.itis.semesterwork.repository.ConfirmCodeRepository;
import ru.itis.semesterwork.repository.UserRepository;
import ru.itis.semesterwork.service.EmailService;
import ru.itis.semesterwork.util.EmailUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

    @Value("${email.ftlh.path}")
    private String pathToEmailPage;

    @Value("${email.confirm.url}")
    private String confirmUrl;

    private final ConfirmCodeRepository confirmCodeRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailUtil emailUtil;
    private final UserMapper userMapper;

    @Override
    public UserResponse confirmEmail(String confirmCode) {
        ConfirmCodeEntity confirmCodeEntity = confirmCodeRepository.findByCode(confirmCode)
                .orElseThrow(ConfirmCodeNotFoundException::new);
        UserEntity userEntity = confirmCodeEntity.getUser();
        userEntity.setVerified(true);
        userRepository.save(userEntity);
        return userMapper.toResponse(userEntity);
    }

    @Override
    public void createCode(LoginRequest loginRequest) {
        UserEntity userEntity = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new UnauthorizedException("Can't login in: " + loginRequest.getEmail() + ". Wrong email or password."));
        if (passwordEncoder.matches(loginRequest.getPassword(), userEntity.getHashPassword())) {
            String newCode = UUID.randomUUID().toString();
            ConfirmCodeEntity confirmCodeEntity = confirmCodeRepository.findByUser(userEntity)
                    .orElse(ConfirmCodeEntity.builder()
                            .user(userEntity)
                            .build());
            confirmCodeEntity.setCode(newCode);
            Map<String, Object> data = new HashMap<>();
            data.put("confirmLink", confirmUrl + newCode);
            data.put("firstName", userEntity.getFirstName());
            data.put("lastName", userEntity.getLastName());
            emailUtil.sendMail(userEntity.getEmail(), "Confirm Your Email", pathToEmailPage, data);
            confirmCodeRepository.save(confirmCodeEntity);
        } else {
            throw new UnauthorizedException("Can't login in: " + loginRequest.getEmail() + ". Wrong email or password.");
        }
    }
}
