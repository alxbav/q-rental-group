package ee.qrental.calculation.adapter.out.persistance.repository;

import ee.qrental.calculation.adapter.out.persistance.jpaentity.RentCalculationResultJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataRentCalculationResultRepository
        extends JpaRepository<RentCalculationResultJpaEntity, Long> {
}