package ru.itis.semesterwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semesterwork.models.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

}
