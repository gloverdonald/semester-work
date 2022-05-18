package ru.itis.semesterwork.service;

import ru.itis.semesterwork.dto.request.BookingRequest;
import ru.itis.semesterwork.dto.response.BookingResponse;

import java.util.List;

public interface BookingService {

    Long save(BookingRequest bookingRequest);

    BookingResponse get(Long id);

    List<BookingResponse> getAll();
}