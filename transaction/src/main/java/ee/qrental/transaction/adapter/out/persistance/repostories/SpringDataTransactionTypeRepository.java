package ee.qrental.transaction.adapter.out.persistance.repostories;

import ee.qrental.transaction.adapter.out.persistance.jpaentity.TransactionTypeJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpringDataTransactionTypeRepository
        extends JpaRepository<TransactionTypeJpaEntity, Long> {

    TransactionTypeJpaEntity findByName(final String name);
}

