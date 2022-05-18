package ru.itis.semesterwork.exceptions;

import static ru.itis.semesterwork.exceptions.MessageConstants.ROLE_NOT_FOUND;

public class RoleNotFoundException extends ModelNotFoundException {

    public RoleNotFoundException() {
        super(ROLE_NOT_FOUND);
    }
}
