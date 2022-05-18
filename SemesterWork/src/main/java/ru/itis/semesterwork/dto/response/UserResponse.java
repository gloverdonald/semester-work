package ru.itis.semesterwork.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.itis.semesterwork.dto.enums.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserResponse {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private Role role;
}
