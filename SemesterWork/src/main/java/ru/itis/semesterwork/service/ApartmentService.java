package ru.itis.semesterwork.service;

import ru.itis.semesterwork.dto.ApartmentSearchDto;
import ru.itis.semesterwork.dto.request.ApartmentRequest;
import ru.itis.semesterwork.dto.request.ApartmentWithAddressRequest;
import ru.itis.semesterwork.dto.response.ApartmentResponse;

import java.util.List;

public interface ApartmentService {

    Boolean isAvailable(ApartmentSearchDto searchDto);

    Long save(ApartmentRequest apartmentDto);

    ApartmentResponse get(Long id);

    List<ApartmentResponse> getAll();

    Long saveWithAddress(ApartmentWithAddressRequest apartmentWithAddressRequest);
}