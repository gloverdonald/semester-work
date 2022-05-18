package ru.itis.semesterwork.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.semesterwork.dto.request.AddressRequest;
import ru.itis.semesterwork.dto.request.ApartmentWithAddressRequest;
import ru.itis.semesterwork.dto.response.AddressResponse;
import ru.itis.semesterwork.models.AddressEntity;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    AddressEntity toAddress(AddressRequest addressRequest);
    AddressRequest toRequest(AddressEntity addressEntity);

    AddressResponse toResponse(AddressEntity addressEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    AddressEntity toAddress(ApartmentWithAddressRequest apartmentWithAddressRequest);
}
