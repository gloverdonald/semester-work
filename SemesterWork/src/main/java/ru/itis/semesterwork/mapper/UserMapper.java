package ru.itis.semesterwork.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.semesterwork.dto.request.RegistrationRequest;
import ru.itis.semesterwork.dto.response.UserResponse;
import ru.itis.semesterwork.models.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toResponse(UserEntity userEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "hashPassword", source = "password")
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    UserEntity toUser(RegistrationRequest registrationRequest);
}
