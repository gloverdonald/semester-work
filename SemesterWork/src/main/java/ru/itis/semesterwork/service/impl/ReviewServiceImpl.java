package ru.itis.semesterwork.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.semesterwork.dto.request.ReviewRequest;
import ru.itis.semesterwork.dto.response.ReviewResponse;
import ru.itis.semesterwork.exceptions.ApartmentNotFoundException;
import ru.itis.semesterwork.exceptions.ReviewNotFoundException;
import ru.itis.semesterwork.exceptions.UserNotFoundException;
import ru.itis.semesterwork.mapper.ReviewMapper;
import ru.itis.semesterwork.models.ApartmentEntity;
import ru.itis.semesterwork.models.ReviewEntity;
import ru.itis.semesterwork.models.UserEntity;
import ru.itis.semesterwork.repository.ApartmentRepository;
import ru.itis.semesterwork.repository.ReviewRepository;
import ru.itis.semesterwork.repository.UserRepository;
import ru.itis.semesterwork.service.ReviewService;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final UserRepository userRepository;
    private final ApartmentRepository apartmentRepository;

    @Override
    public Long save(ReviewRequest reviewRequest) {
        UserEntity userEntity = userRepository.findById(reviewRequest.getAuthorId())
                .orElseThrow(UserNotFoundException::new);
        ApartmentEntity apartmentEntity = apartmentRepository.findById(reviewRequest.getApartmentId())
                .orElseThrow(ApartmentNotFoundException::new);
        ReviewEntity reviewEntity = reviewMapper.toReview(reviewRequest);
        reviewEntity.setAuthor(userEntity);
        reviewEntity.setApartment(apartmentEntity);
        return reviewRepository.save(reviewEntity).getId();
    }

    @Override
    public ReviewResponse get(Long id) {
        return reviewMapper.toResponse(reviewRepository.findById(id).orElseThrow(ReviewNotFoundException::new));
    }
}
