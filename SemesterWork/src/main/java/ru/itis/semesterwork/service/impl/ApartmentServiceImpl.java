package ru.itis.semesterwork.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.semesterwork.dto.ApartmentSearchDto;
import ru.itis.semesterwork.dto.request.ApartmentRequest;
import ru.itis.semesterwork.dto.request.ApartmentWithAddressRequest;
import ru.itis.semesterwork.dto.response.ApartmentResponse;
import ru.itis.semesterwork.exceptions.AddressNotFoundException;
import ru.itis.semesterwork.exceptions.ApartmentNotFoundException;
import ru.itis.semesterwork.exceptions.UserNotFoundException;
import ru.itis.semesterwork.mapper.AddressMapper;
import ru.itis.semesterwork.mapper.ApartmentMapper;
import ru.itis.semesterwork.models.AddressEntity;
import ru.itis.semesterwork.models.ApartmentEntity;
import ru.itis.semesterwork.models.UserEntity;
import ru.itis.semesterwork.repository.AddressRepository;
import ru.itis.semesterwork.repository.ApartmentRepository;
import ru.itis.semesterwork.repository.BookingRepository;
import ru.itis.semesterwork.repository.UserRepository;
import ru.itis.semesterwork.service.ApartmentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepository;
    private final ApartmentMapper apartmentMapper;
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;

    @Override
    public Boolean isAvailable(ApartmentSearchDto searchDto) {
        return bookingRepository.isAvailable(searchDto.getId(), searchDto.getDateStart(), searchDto.getDateEnd());
    }

    @Override
    public Long save(ApartmentRequest apartmentRequest) {
        AddressEntity addressEntity = addressRepository
                .findById(apartmentRequest.getAddressId()).orElseThrow(AddressNotFoundException::new);
        UserEntity userEntity = userRepository
                .findById(apartmentRequest.getOwnerId()).orElseThrow(UserNotFoundException::new);

        ApartmentEntity apartment = apartmentMapper.toApartment(apartmentRequest);
        apartment.setAddress(addressEntity);
        apartment.setOwner(userEntity);
        return apartmentRepository.save(apartment).getId();
    }

    @Override
    public ApartmentResponse get(Long id) {
        ApartmentEntity apartment = apartmentRepository.findById(id).orElseThrow(ApartmentNotFoundException::new);
        return apartmentMapper.toResponse(apartment);
    }

    @Override
    public List<ApartmentResponse> getAll() {
        return apartmentRepository.findAll()
                .stream()
                .map(apartmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Long saveWithAddress(ApartmentWithAddressRequest apartmentWithAddressRequest) {
        UserEntity userEntity = userRepository
                .findById(apartmentWithAddressRequest.getOwnerId()).orElseThrow(UserNotFoundException::new);
        ApartmentEntity apartmentEntity = apartmentMapper.toApartment(apartmentWithAddressRequest);
        AddressEntity addressEntity = addressMapper.toAddress(apartmentWithAddressRequest);
        apartmentEntity.setAddress(addressRepository.save(addressEntity));
        apartmentEntity.setOwner(userEntity);
        return apartmentRepository.save(apartmentEntity).getId();
    }
}
