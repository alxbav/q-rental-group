package ee.qrental.link.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SpringDataLinkRepository
        extends JpaRepository<LinkJpaEntity, Long> {

    Optional<LinkJpaEntity> getLinkJpaEntitiesByDriverId(String driverId);
}

