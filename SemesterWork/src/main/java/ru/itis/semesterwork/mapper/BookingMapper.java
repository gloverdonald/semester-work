package ru.itis.semesterwork.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.semesterwork.dto.request.BookingRequest;
import ru.itis.semesterwork.dto.response.BookingResponse;
import ru.itis.semesterwork.models.BookingEntity;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    BookingEntity toBooking(BookingResponse bookingResponse);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    BookingEntity toBooking(BookingRequest bookingRequest);

    BookingResponse toResponse(BookingEntity bookingEntity);
}
