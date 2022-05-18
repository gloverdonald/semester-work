package ru.itis.semesterwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semesterwork.models.ConfirmCodeEntity;
import ru.itis.semesterwork.models.UserEntity;

import java.util.Optional;

public interface ConfirmCodeRepository extends JpaRepository<ConfirmCodeEntity, Long> {

    Optional<ConfirmCodeEntity> findByCode(String code);

    Optional<ConfirmCodeEntity> findByUser(UserEntity userEntity);
}
