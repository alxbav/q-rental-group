package ee.qrental.transaction.adapter.out.persistance.repostories;

import ee.qrental.transaction.adapter.out.persistance.jpaentity.FirmJpaEntity;
import ee.qrental.transaction.adapter.out.persistance.jpaentity.TransactionTypeJpaEntity;
import ee.qrental.transaction.domain.Firm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpringDataFirmRepository
        extends JpaRepository<FirmJpaEntity, Long> {

    FirmJpaEntity findByName(final String name);
}

