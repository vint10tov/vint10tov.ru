package ru.v10tov.repository;

import org.springframework.data.repository.CrudRepository;
import ru.v10tov.entity.ObjectEntity;

public interface ObjectRepository extends CrudRepository<ObjectEntity, Long> {
}
