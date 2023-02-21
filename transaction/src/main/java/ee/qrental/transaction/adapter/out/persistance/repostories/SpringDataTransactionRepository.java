package ee.qrental.transaction.adapter.out.persistance.repostories;

import ee.qrental.transaction.adapter.out.persistance.jpaentity.TransactionJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface SpringDataTransactionRepository
        extends JpaRepository<TransactionJpaEntity, Long> {

    List<TransactionJpaEntity> findByDriverId(Long driverId);

    List<TransactionJpaEntity> findAllByDateBetween(
            LocalDate dateStart, LocalDate dateEnd);

    List<TransactionJpaEntity> findAllByDateBetweenAndDriverId(
            LocalDate dateStart, LocalDate dateEnd, Long driverId);
}

