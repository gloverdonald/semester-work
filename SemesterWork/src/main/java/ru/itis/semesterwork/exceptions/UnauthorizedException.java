package ru.itis.semesterwork.exceptions;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends HttpServiceException {

    public UnauthorizedException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }
}
