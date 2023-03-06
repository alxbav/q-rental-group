package ee.qrental.driver.adapter.out.persistance.repositories;

import ee.qrental.driver.adapter.out.persistance.jpaentity.DriverJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataDriverRepository
        extends JpaRepository<DriverJpaEntity, Long> {
}
