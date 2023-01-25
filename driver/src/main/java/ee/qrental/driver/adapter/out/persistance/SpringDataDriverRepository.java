package ee.qrental.driver.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataDriverRepository
        extends JpaRepository<DriverJpaEntity, Long> {
}
