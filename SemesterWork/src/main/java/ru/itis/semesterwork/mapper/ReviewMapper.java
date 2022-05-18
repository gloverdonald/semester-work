package ru.itis.semesterwork.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.semesterwork.dto.request.ReviewRequest;
import ru.itis.semesterwork.dto.response.ReviewResponse;
import ru.itis.semesterwork.models.ReviewEntity;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    ReviewEntity toReview(ReviewRequest request);

    @Mapping(target = "authorId", source = "author.id")
    @Mapping(target = "apartmentId", source = "apartment.id")
    ReviewResponse toResponse(ReviewEntity reviewEntity);
}
