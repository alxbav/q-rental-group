package ee.qrental.transactiontype.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SpringDataTransactionTypeRepository
        extends JpaRepository<TransactionTypeJpaEntity, Long> {

    Optional<TransactionTypeJpaEntity> getTransactionTypeJpaEntityByTypeTr(String typeTr);
}

