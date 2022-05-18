package ru.itis.semesterwork.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.semesterwork.dto.request.BookingRequest;
import ru.itis.semesterwork.dto.response.BookingResponse;
import ru.itis.semesterwork.exceptions.ApartmentNotFoundException;
import ru.itis.semesterwork.exceptions.BookingNotFoundException;
import ru.itis.semesterwork.exceptions.UserNotFoundException;
import ru.itis.semesterwork.mapper.BookingMapper;
import ru.itis.semesterwork.models.ApartmentEntity;
import ru.itis.semesterwork.models.BookingEntity;
import ru.itis.semesterwork.models.UserEntity;
import ru.itis.semesterwork.repository.ApartmentRepository;
import ru.itis.semesterwork.repository.BookingRepository;
import ru.itis.semesterwork.repository.UserRepository;
import ru.itis.semesterwork.service.BookingService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final ApartmentRepository apartmentRepository;
    private final UserRepository userRepository;

    @Override
    public Long save(BookingRequest bookingRequest) {
        ApartmentEntity apartment = apartmentRepository
                .findById(bookingRequest.getApartmentId()).orElseThrow(ApartmentNotFoundException::new);

        UserEntity user = userRepository
                .findById(bookingRequest.getCustomerId()).orElseThrow(UserNotFoundException::new);

        BookingEntity booking = bookingMapper.toBooking(bookingRequest);
        booking.setCustomer(user);
        booking.setApartment(apartment);
        return bookingRepository.save(booking).getId();
    }

    @Override
    public BookingResponse get(Long id) {
        BookingEntity booking = bookingRepository.findById(id).orElseThrow(BookingNotFoundException::new);
        return bookingMapper.toResponse(booking);
    }

    @Override
    public List<BookingResponse> getAll() {
        return bookingRepository.findAll()
                .stream()
                .map(bookingMapper::toResponse)
                .collect(Collectors.toList());
    }
}
