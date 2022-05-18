package ru.itis.semesterwork.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.semesterwork.dto.ApartmentSearchDto;
import ru.itis.semesterwork.dto.request.ApartmentRequest;
import ru.itis.semesterwork.dto.request.ApartmentWithAddressRequest;
import ru.itis.semesterwork.dto.response.ApartmentResponse;
import ru.itis.semesterwork.service.ApartmentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apartment")
public class ApartmentController {

    private final ApartmentService apartmentService;

    @PostMapping("/add")
    private Long create(@Valid @RequestBody ApartmentRequest apartment) {
        return apartmentService.save(apartment);
    }

    @PostMapping("/add-with-address")
    private Long createWithAddress(@Valid @RequestBody ApartmentWithAddressRequest apartmentWithAddressRequest) {
        return apartmentService.saveWithAddress(apartmentWithAddressRequest);
    }

    @GetMapping("/{id}")
    private ApartmentResponse get(@PathVariable Long id) {
        return apartmentService.get(id);
    }

    @GetMapping("/availability")
    private Boolean check(@RequestBody ApartmentSearchDto searchDto) {
        return apartmentService.isAvailable(searchDto);
    }

    @GetMapping("/all")
    private List<ApartmentResponse> getAll() {
        return apartmentService.getAll();
    }
}
