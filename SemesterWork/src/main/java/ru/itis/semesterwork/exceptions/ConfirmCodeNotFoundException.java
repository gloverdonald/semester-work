package ru.itis.semesterwork.exceptions;

import static ru.itis.semesterwork.exceptions.MessageConstants.CONFIRM_CODE_NOT_FOUND;

public class ConfirmCodeNotFoundException extends ModelNotFoundException {

    public ConfirmCodeNotFoundException() {
        super(CONFIRM_CODE_NOT_FOUND);
    }
}
