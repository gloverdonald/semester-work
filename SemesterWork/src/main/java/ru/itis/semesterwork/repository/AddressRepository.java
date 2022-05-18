package ru.itis.semesterwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semesterwork.models.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}