package ru.itis.semesterwork.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.semesterwork.dto.request.ReviewRequest;
import ru.itis.semesterwork.dto.response.ReviewResponse;
import ru.itis.semesterwork.service.ReviewService;

@RequiredArgsConstructor
@RequestMapping("/review")
@RestController
public class ReviewController {

    public final ReviewService reviewService;

    @PostMapping("/add")
    public Long create(@RequestBody ReviewRequest reviewRequest) {
        return reviewService.save(reviewRequest);
    }

    @GetMapping("/{id}")
    public ReviewResponse get(@PathVariable Long id) {
        return reviewService.get(id);
    }

    @GetMapping
    public String getTest() {
        return "test";
    }
}