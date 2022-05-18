package ru.itis.semesterwork.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApartmentResponse {

    private Long id;

    private Long price;

    private Long addressId;

    private Long ownerId;
}
