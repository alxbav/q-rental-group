package ee.qrental.link.adapter.out.persistance.repository;

import ee.qrental.link.adapter.out.persistance.jpaentity.LinkJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataLinkRepository
        extends JpaRepository<LinkJpaEntity, Long> {
}

