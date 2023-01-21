package ee.qrental.driverpotential.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataDriverPotentialRepository
        extends JpaRepository<DriverPotentialJpaEntity, Long> {
}
