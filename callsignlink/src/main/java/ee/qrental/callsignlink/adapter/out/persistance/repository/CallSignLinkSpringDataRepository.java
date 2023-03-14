package ee.qrental.callsignlink.adapter.out.persistance.repository;

import ee.qrental.callsignlink.adapter.out.persistance.jpaentity.CallSignLinkJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CallSignLinkSpringDataRepository
        extends JpaRepository<CallSignLinkJpaEntity, Long> {

    List<CallSignLinkJpaEntity> findAllByDateEndIsNull();

    CallSignLinkJpaEntity findFirstByDriverId(final Long driverId);
}
