package ee.qrental.callsignlink.adapter.out.persistance.repository;

import ee.qrental.callsignlink.adapter.out.persistance.jpaentity.CallSignJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallSignSpringDataRepository
        extends JpaRepository<CallSignJpaEntity, Long> {
    CallSignJpaEntity findByCallSign(final Integer callSSign);
}