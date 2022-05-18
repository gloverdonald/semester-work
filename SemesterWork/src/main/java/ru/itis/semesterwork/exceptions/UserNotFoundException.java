package ru.itis.semesterwork.exceptions;

import static ru.itis.semesterwork.exceptions.MessageConstants.USER_NOT_FOUND;

public class UserNotFoundException extends ModelNotFoundException {

    public UserNotFoundException() {
        super(USER_NOT_FOUND);
    }
}
