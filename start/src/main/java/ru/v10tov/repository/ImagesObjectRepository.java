package ru.v10tov.repository;

import org.springframework.data.repository.CrudRepository;
import ru.v10tov.entity.ImagesObject;

import java.util.List;

public interface ImagesObjectRepository extends CrudRepository<ImagesObject, Long> {
}
