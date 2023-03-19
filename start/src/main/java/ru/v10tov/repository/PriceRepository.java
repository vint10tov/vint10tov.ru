package ru.v10tov.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.v10tov.entity.PriceEntity;
import java.util.List;

// вне хогвардса
@Repository
public interface PriceRepository extends CrudRepository<PriceEntity, Long> {
    List<PriceEntity> findByElectricianTrue ();
    List<PriceEntity> findByFinishingTrue ();
    List<PriceEntity> findByPlumbingTrue ();
    List<PriceEntity> findByAirConditionersTrue ();
    List<PriceEntity> findByDesignTrue ();
}
