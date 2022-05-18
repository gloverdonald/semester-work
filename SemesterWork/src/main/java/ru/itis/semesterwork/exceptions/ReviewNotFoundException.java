package ru.itis.semesterwork.exceptions;

import static ru.itis.semesterwork.exceptions.MessageConstants.REVIEW_NOT_FOUND;

public class ReviewNotFoundException extends ModelNotFoundException {
    public ReviewNotFoundException() {
        super(REVIEW_NOT_FOUND);
    }
}
