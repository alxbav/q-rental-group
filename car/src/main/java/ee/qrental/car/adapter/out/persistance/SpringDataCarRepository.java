package ee.qrental.car.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataCarRepository
        extends JpaRepository<CarJpaEntity, Long> {

    Optional<CarJpaEntity> getCarJpaEntityByRegNumber(String regNumber);
}
