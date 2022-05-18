package ru.itis.semesterwork.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.semesterwork.dto.request.ApartmentRequest;
import ru.itis.semesterwork.dto.request.ApartmentWithAddressRequest;
import ru.itis.semesterwork.dto.response.ApartmentResponse;
import ru.itis.semesterwork.dto.response.ApartmentResponse.ApartmentResponseBuilder;
import ru.itis.semesterwork.models.AddressEntity;
import ru.itis.semesterwork.models.ApartmentEntity;
import ru.itis.semesterwork.models.ApartmentEntity.ApartmentEntityBuilder;
import ru.itis.semesterwork.models.UserEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-18T02:08:23+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class ApartmentMapperImpl implements ApartmentMapper {

    @Override
    public ApartmentEntity toApartment(ApartmentResponse apartmentResponse) {
        if ( apartmentResponse == null ) {
            return null;
        }

        ApartmentEntityBuilder<?, ?> apartmentEntity = ApartmentEntity.builder();

        apartmentEntity.price( apartmentResponse.getPrice() );

        return apartmentEntity.build();
    }

    @Override
    public ApartmentEntity toApartment(ApartmentRequest apartmentRequest) {
        if ( apartmentRequest == null ) {
            return null;
        }

        ApartmentEntityBuilder<?, ?> apartmentEntity = ApartmentEntity.builder();

        apartmentEntity.price( apartmentRequest.getPrice() );

        return apartmentEntity.build();
    }

    @Override
    public ApartmentResponse toResponse(ApartmentEntity apartmentEntity) {
        if ( apartmentEntity == null ) {
            return null;
        }

        ApartmentResponseBuilder apartmentResponse = ApartmentResponse.builder();

        apartmentResponse.addressId( apartmentEntityAddressId( apartmentEntity ) );
        apartmentResponse.ownerId( apartmentEntityOwnerId( apartmentEntity ) );
        apartmentResponse.id( apartmentEntity.getId() );
        apartmentResponse.price( apartmentEntity.getPrice() );

        return apartmentResponse.build();
    }

    @Override
    public ApartmentEntity toApartment(ApartmentWithAddressRequest apartmentWithAddressRequest) {
        if ( apartmentWithAddressRequest == null ) {
            return null;
        }

        ApartmentEntityBuilder<?, ?> apartmentEntity = ApartmentEntity.builder();

        apartmentEntity.price( apartmentWithAddressRequest.getPrice() );

        return apartmentEntity.build();
    }

    private Long apartmentEntityAddressId(ApartmentEntity apartmentEntity) {
        if ( apartmentEntity == null ) {
            return null;
        }
        AddressEntity address = apartmentEntity.getAddress();
        if ( address == null ) {
            return null;
        }
        Long id = address.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long apartmentEntityOwnerId(ApartmentEntity apartmentEntity) {
        if ( apartmentEntity == null ) {
            return null;
        }
        UserEntity owner = apartmentEntity.getOwner();
        if ( owner == null ) {
            return null;
        }
        Long id = owner.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
