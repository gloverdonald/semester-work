package ru.itis.semesterwork.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.semesterwork.dto.request.AddressRequest;
import ru.itis.semesterwork.dto.request.AddressRequest.AddressRequestBuilder;
import ru.itis.semesterwork.dto.request.ApartmentWithAddressRequest;
import ru.itis.semesterwork.dto.response.AddressResponse;
import ru.itis.semesterwork.dto.response.AddressResponse.AddressResponseBuilder;
import ru.itis.semesterwork.models.AddressEntity;
import ru.itis.semesterwork.models.AddressEntity.AddressEntityBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-18T02:08:24+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressEntity toAddress(AddressRequest addressRequest) {
        if ( addressRequest == null ) {
            return null;
        }

        AddressEntityBuilder<?, ?> addressEntity = AddressEntity.builder();

        addressEntity.country( addressRequest.getCountry() );
        addressEntity.city( addressRequest.getCity() );
        addressEntity.street( addressRequest.getStreet() );
        addressEntity.houseNumber( addressRequest.getHouseNumber() );

        return addressEntity.build();
    }

    @Override
    public AddressRequest toRequest(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        AddressRequestBuilder addressRequest = AddressRequest.builder();

        addressRequest.country( addressEntity.getCountry() );
        addressRequest.city( addressEntity.getCity() );
        addressRequest.street( addressEntity.getStreet() );
        addressRequest.houseNumber( addressEntity.getHouseNumber() );

        return addressRequest.build();
    }

    @Override
    public AddressResponse toResponse(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        AddressResponseBuilder addressResponse = AddressResponse.builder();

        addressResponse.id( addressEntity.getId() );
        addressResponse.country( addressEntity.getCountry() );
        addressResponse.city( addressEntity.getCity() );
        addressResponse.street( addressEntity.getStreet() );
        addressResponse.houseNumber( addressEntity.getHouseNumber() );

        return addressResponse.build();
    }

    @Override
    public AddressEntity toAddress(ApartmentWithAddressRequest apartmentWithAddressRequest) {
        if ( apartmentWithAddressRequest == null ) {
            return null;
        }

        AddressEntityBuilder<?, ?> addressEntity = AddressEntity.builder();

        addressEntity.country( apartmentWithAddressRequest.getCountry() );
        addressEntity.city( apartmentWithAddressRequest.getCity() );
        addressEntity.street( apartmentWithAddressRequest.getStreet() );
        addressEntity.houseNumber( apartmentWithAddressRequest.getHouseNumber() );

        return addressEntity.build();
    }
}
