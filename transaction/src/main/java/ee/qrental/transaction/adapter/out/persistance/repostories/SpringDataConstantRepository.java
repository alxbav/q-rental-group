package ee.qrental.transaction.adapter.out.persistance.repostories;

import ee.qrental.transaction.adapter.out.persistance.jpaentity.ConstantJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpringDataConstantRepository
        extends JpaRepository<ConstantJpaEntity, Long> {
}

