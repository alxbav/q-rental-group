package ee.qrental.callsignlink.adapter.out.persistance.mapper;

import ee.qrental.callsignlink.adapter.out.persistance.jpaentity.CallSignJpaEntity;
import ee.qrental.callsignlink.domain.CallSign;
import ee.qrental.common.core.api.mapper.DomainMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CallSignMapper implements DomainMapper<CallSign, CallSignJpaEntity> {

    @Override
    public CallSign mapToDomain(final CallSignJpaEntity jpaEntity) {
        if (jpaEntity == null) {
            return null;
        }
        final var domain = new CallSign();
        domain.setId(jpaEntity.getId());
        domain.setCallSign(jpaEntity.getCallSign());
        domain.setComment(jpaEntity.getComment());

        return domain;
    }

    @Override
    public CallSignJpaEntity mapToEntity(final CallSign domain) {
        if (domain == null) {
            return null;
        }
        final var jpaEntity = new CallSignJpaEntity();
        jpaEntity.setId(domain.getId());
        jpaEntity.setCallSign(domain.getCallSign());
        jpaEntity.setComment(domain.getComment());

        return jpaEntity;
    }
}
