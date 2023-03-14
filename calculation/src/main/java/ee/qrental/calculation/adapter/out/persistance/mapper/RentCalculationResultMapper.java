package ee.qrental.calculation.adapter.out.persistance.mapper;

import ee.qrental.common.core.api.adapter.mapper.DomainMapper;
import ee.qrental.calculation.adapter.out.persistance.jpaentity.RentCalculationResultJpaEntity;
import ee.qrental.calculation.domain.RentCalculationResult;
import org.springframework.stereotype.Component;

@Component
public class RentCalculationResultMapper
        implements DomainMapper<RentCalculationResult, RentCalculationResultJpaEntity> {

    @Override
    public RentCalculationResult mapToDomain(
            final RentCalculationResultJpaEntity calculationResult) {
        final var domain = new RentCalculationResult();
        domain.setId(calculationResult.getId());
        domain.setTransactionId(calculationResult.getTransactionId());
        domain.setLinkId(calculationResult.getLinkId());

        return domain;
    }

    @Override
    public RentCalculationResultJpaEntity mapToEntity(
            final RentCalculationResult domain) {
        final var entity = new RentCalculationResultJpaEntity();
        entity.setId(domain.getId());
        entity.setTransactionId(domain.getTransactionId());
        entity.setLinkId(domain.getLinkId());

        return entity;
    }
}