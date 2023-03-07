package ee.qrental.car.adapter.out.persistance.repository;

import ee.qrental.car.adapter.out.persistance.jpaentity.CarJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataCarRepository
        extends JpaRepository<CarJpaEntity, Long> {

    CarJpaEntity findByRegNumber(final String regNumber);
}
