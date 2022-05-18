package ru.itis.semesterwork.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.semesterwork.dto.request.ReviewRequest;
import ru.itis.semesterwork.dto.response.ReviewResponse;
import ru.itis.semesterwork.dto.response.ReviewResponse.ReviewResponseBuilder;
import ru.itis.semesterwork.models.ApartmentEntity;
import ru.itis.semesterwork.models.ReviewEntity;
import ru.itis.semesterwork.models.ReviewEntity.ReviewEntityBuilder;
import ru.itis.semesterwork.models.UserEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-18T02:08:23+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public ReviewEntity toReview(ReviewRequest request) {
        if ( request == null ) {
            return null;
        }

        ReviewEntityBuilder<?, ?> reviewEntity = ReviewEntity.builder();

        reviewEntity.rating( request.getRating() );
        reviewEntity.message( request.getMessage() );

        return reviewEntity.build();
    }

    @Override
    public ReviewResponse toResponse(ReviewEntity reviewEntity) {
        if ( reviewEntity == null ) {
            return null;
        }

        ReviewResponseBuilder reviewResponse = ReviewResponse.builder();

        reviewResponse.authorId( reviewEntityAuthorId( reviewEntity ) );
        reviewResponse.apartmentId( reviewEntityApartmentId( reviewEntity ) );
        reviewResponse.id( reviewEntity.getId() );
        reviewResponse.rating( reviewEntity.getRating() );
        reviewResponse.message( reviewEntity.getMessage() );

        return reviewResponse.build();
    }

    private Long reviewEntityAuthorId(ReviewEntity reviewEntity) {
        if ( reviewEntity == null ) {
            return null;
        }
        UserEntity author = reviewEntity.getAuthor();
        if ( author == null ) {
            return null;
        }
        Long id = author.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long reviewEntityApartmentId(ReviewEntity reviewEntity) {
        if ( reviewEntity == null ) {
            return null;
        }
        ApartmentEntity apartment = reviewEntity.getApartment();
        if ( apartment == null ) {
            return null;
        }
        Long id = apartment.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
