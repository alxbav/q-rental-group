package ee.qrental.transaction.adapter.out.persistance.repostories;

import ee.qrental.transaction.adapter.out.persistance.jpaentity.TransactionJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;


@Repository
public interface SpringDataTransactionRepository
        extends JpaRepository<TransactionJpaEntity, Long> {

    Set<TransactionJpaEntity> findByDriverId(Long driverId);
}

