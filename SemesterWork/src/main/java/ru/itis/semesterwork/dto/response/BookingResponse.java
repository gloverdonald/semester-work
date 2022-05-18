package ru.itis.semesterwork.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingResponse {

    private Long id;

    private Date dateStart;

    private Date dateEnd;

    private Long apartmentId;

    private Long customerId;
}
