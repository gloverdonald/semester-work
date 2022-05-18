package ru.itis.semesterwork.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.semesterwork.dto.request.AddressRequest;
import ru.itis.semesterwork.dto.response.AddressResponse;
import ru.itis.semesterwork.exceptions.AddressNotFoundException;
import ru.itis.semesterwork.mapper.AddressMapper;
import ru.itis.semesterwork.models.AddressEntity;
import ru.itis.semesterwork.repository.AddressRepository;
import ru.itis.semesterwork.service.AddressService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public Long save(AddressRequest addressRequest) {
        AddressEntity address = addressMapper.toAddress(addressRequest);
        return addressRepository.save(address).getId();
    }

    @Override
    public AddressResponse get(Long id) {
        AddressEntity address = addressRepository.findById(id).orElseThrow(AddressNotFoundException::new);
        return addressMapper.toResponse(address);
    }

    @Override
    public List<AddressResponse> getAll() {
        return addressRepository.findAll()
                .stream()
                .map(addressMapper::toResponse)
                .collect(Collectors.toList());
    }
}
