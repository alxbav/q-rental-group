package ee.qrental.calculation.adapter.out.persistance.repository;

import ee.qrental.calculation.adapter.out.persistance.jpaentity.RentCalculationJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataRentCalculationRepository
        extends JpaRepository<RentCalculationJpaEntity, Long> {

    RentCalculationJpaEntity findTopByOrderByActionDateDesc();
}
