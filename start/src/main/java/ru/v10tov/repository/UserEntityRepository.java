package ru.v10tov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.v10tov.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
