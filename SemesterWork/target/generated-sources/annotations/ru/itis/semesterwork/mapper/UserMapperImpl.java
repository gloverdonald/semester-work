package ru.itis.semesterwork.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.semesterwork.dto.request.RegistrationRequest;
import ru.itis.semesterwork.dto.response.UserResponse;
import ru.itis.semesterwork.dto.response.UserResponse.UserResponseBuilder;
import ru.itis.semesterwork.models.UserEntity;
import ru.itis.semesterwork.models.UserEntity.UserEntityBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-18T02:08:24+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse toResponse(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserResponseBuilder<?, ?> userResponse = UserResponse.builder();

        userResponse.id( userEntity.getId() );
        userResponse.email( userEntity.getEmail() );
        userResponse.firstName( userEntity.getFirstName() );
        userResponse.lastName( userEntity.getLastName() );
        userResponse.role( userEntity.getRole() );

        return userResponse.build();
    }

    @Override
    public UserEntity toUser(RegistrationRequest registrationRequest) {
        if ( registrationRequest == null ) {
            return null;
        }

        UserEntityBuilder<?, ?> userEntity = UserEntity.builder();

        userEntity.hashPassword( registrationRequest.getPassword() );
        userEntity.firstName( registrationRequest.getFirstName() );
        userEntity.lastName( registrationRequest.getLastName() );
        userEntity.email( registrationRequest.getEmail() );
        userEntity.role( registrationRequest.getRole() );

        return userEntity.build();
    }
}
