package ee.qrental.driver.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataDriverRepository
        extends JpaRepository<DriverJpaEntity, Long> {

    Optional<DriverJpaEntity> getDriverJpaEntityByPhone(String phone);
}
