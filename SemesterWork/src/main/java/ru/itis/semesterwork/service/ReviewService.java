package ru.itis.semesterwork.service;

import ru.itis.semesterwork.dto.request.ReviewRequest;
import ru.itis.semesterwork.dto.response.ReviewResponse;

public interface ReviewService {

    Long save(ReviewRequest reviewRequest);

    ReviewResponse get(Long id);
}
