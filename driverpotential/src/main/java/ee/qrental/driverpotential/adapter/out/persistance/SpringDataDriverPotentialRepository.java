package ee.qrental.driverpotential.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataDriverPotentialRepository
        extends JpaRepository<DriverPotentialJpaEntity, Long> {

    Optional<DriverPotentialJpaEntity> getDriverPotentialJpaEntityByPhone(String phone);
}
