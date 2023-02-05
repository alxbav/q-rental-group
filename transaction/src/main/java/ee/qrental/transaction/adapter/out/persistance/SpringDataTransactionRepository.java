package ee.qrental.transaction.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SpringDataTransactionRepository
        extends JpaRepository<TransactionJpaEntity, Long> {

    Optional<TransactionJpaEntity> getTransactionTypeJpaEntityByTypeTr(String typeTr);
}

