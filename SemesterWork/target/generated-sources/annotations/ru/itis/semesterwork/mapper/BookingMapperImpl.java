package ru.itis.semesterwork.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.semesterwork.dto.request.BookingRequest;
import ru.itis.semesterwork.dto.response.BookingResponse;
import ru.itis.semesterwork.dto.response.BookingResponse.BookingResponseBuilder;
import ru.itis.semesterwork.models.BookingEntity;
import ru.itis.semesterwork.models.BookingEntity.BookingEntityBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-18T02:08:24+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Override
    public BookingEntity toBooking(BookingResponse bookingResponse) {
        if ( bookingResponse == null ) {
            return null;
        }

        BookingEntityBuilder<?, ?> bookingEntity = BookingEntity.builder();

        bookingEntity.dateStart( bookingResponse.getDateStart() );
        bookingEntity.dateEnd( bookingResponse.getDateEnd() );

        return bookingEntity.build();
    }

    @Override
    public BookingEntity toBooking(BookingRequest bookingRequest) {
        if ( bookingRequest == null ) {
            return null;
        }

        BookingEntityBuilder<?, ?> bookingEntity = BookingEntity.builder();

        bookingEntity.dateStart( bookingRequest.getDateStart() );
        bookingEntity.dateEnd( bookingRequest.getDateEnd() );

        return bookingEntity.build();
    }

    @Override
    public BookingResponse toResponse(BookingEntity bookingEntity) {
        if ( bookingEntity == null ) {
            return null;
        }

        BookingResponseBuilder bookingResponse = BookingResponse.builder();

        bookingResponse.id( bookingEntity.getId() );
        bookingResponse.dateStart( bookingEntity.getDateStart() );
        bookingResponse.dateEnd( bookingEntity.getDateEnd() );

        return bookingResponse.build();
    }
}
