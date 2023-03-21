package ee.qrental.callsignlink.adapter.out.persistance.mapper;

import ee.qrental.callsignlink.adapter.out.persistance.jpaentity.CallSignLinkJpaEntity;
import ee.qrental.callsignlink.adapter.out.persistance.repository.CallSignSpringDataRepository;
import ee.qrental.callsignlink.domain.CallSignLink;
import ee.qrental.common.core.api.adapter.mapper.DomainMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CallSignLinkMapper implements DomainMapper<CallSignLink, CallSignLinkJpaEntity> {

    private final CallSignSpringDataRepository callSignRepository;

    @Override
    public CallSignLink mapToDomain(final CallSignLinkJpaEntity jpaEntity) {
        if (jpaEntity == null) {
            return null;
        }
        final var domain = new CallSignLink();
        domain.setId(jpaEntity.getId());
        domain.setDriverId(jpaEntity.getDriverId());
        domain.setCallSignId(jpaEntity.getCallSign().getId());
        domain.setDateStart(jpaEntity.getDateStart());
        domain.setDateEnd(jpaEntity.getDateEnd());
        domain.setComment(jpaEntity.getComment());

        return domain;
    }

    @Override
    public CallSignLinkJpaEntity mapToEntity(final CallSignLink domain) {
        final var callSign = callSignRepository.getReferenceById(domain.getCallSignId());
        final var jpaEntity = new CallSignLinkJpaEntity();
        jpaEntity.setId(domain.getId());
        jpaEntity.setDriverId(domain.getDriverId());
        jpaEntity.setCallSign(callSign);
        jpaEntity.setDateStart(domain.getDateStart());
        jpaEntity.setDateEnd(domain.getDateEnd());
        jpaEntity.setComment(domain.getComment());

        return jpaEntity;
    }
}
