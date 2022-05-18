package ru.itis.semesterwork.dto.request;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {

    @NotNull(message= "salary may not be empty")
    @Range(min = 1, max = 5)
    private Integer rating;

    private String message;

    private Long apartmentId;

    private Long authorId;
}
