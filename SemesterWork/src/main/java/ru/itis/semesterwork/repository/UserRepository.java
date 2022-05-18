package ru.itis.semesterwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semesterwork.models.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
}
