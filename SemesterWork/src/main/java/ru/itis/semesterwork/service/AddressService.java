package ru.itis.semesterwork.service;

import ru.itis.semesterwork.dto.request.AddressRequest;
import ru.itis.semesterwork.dto.response.AddressResponse;

import java.util.List;

public interface AddressService {

    Long save(AddressRequest addressRequest);

    AddressResponse get(Long id);

    List<AddressResponse> getAll();
}