package ee.qrental.calculation.adapter.out.persistance.repository;

import ee.qrental.calculation.adapter.out.persistance.jpaentity.RentCalculationJpaEntity;
import ee.qrental.transaction.adapter.out.persistance.jpaentity.TransactionJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface SpringDataRentCalculationRepository
        extends JpaRepository<RentCalculationJpaEntity, Long> {

    RentCalculationJpaEntity findTopByOrderByActionDateDesc();

    @Query(value = "select rc.*" +
            "from rent_calculation rc" +
            "         left join rent_calculation_result rcr on rc.id = rcr.calculation_id " +
            "where rcr.link_id = :linkId and rc.action_date> :fromDate " +
            "order by rc.action_date desc limit 1",
            nativeQuery = true)
    RentCalculationJpaEntity findLastCalculationAfterDateByLink(
            @Param("linkId") Long linkId,
            @Param("fromDate") LocalDate fromDate);

    @Query(value = "SELECT * FROM transaction tx " +
            "WHERE tx.id  in (" +
            "select clr.transaction_id from rent_calculation_result clr " +
            "where clr.calculation_id = :calculationId)",
            nativeQuery = true)
    Collection<TransactionJpaEntity> findAllByCalculationId(@Param("calculationId") Long calculationId);
}