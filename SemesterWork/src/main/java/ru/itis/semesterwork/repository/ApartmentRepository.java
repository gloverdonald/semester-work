package ru.itis.semesterwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semesterwork.models.ApartmentEntity;

public interface ApartmentRepository extends JpaRepository<ApartmentEntity, Long> {
}
