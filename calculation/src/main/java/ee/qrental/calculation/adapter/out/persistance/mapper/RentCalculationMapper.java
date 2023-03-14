package ee.qrental.calculation.adapter.out.persistance.mapper;

import ee.qrental.calculation.adapter.out.persistance.jpaentity.RentCalculationJpaEntity;
import ee.qrental.calculation.adapter.out.persistance.jpaentity.RentCalculationResultJpaEntity;
import ee.qrental.calculation.domain.RentCalculation;
import ee.qrental.calculation.domain.RentCalculationResult;
import ee.qrental.common.core.api.adapter.mapper.DomainMapper;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;

@Component
public class RentCalculationMapper
        implements DomainMapper<RentCalculation, RentCalculationJpaEntity> {

    @Override
    public RentCalculation mapToDomain(final RentCalculationJpaEntity jpaEntity) {
        final var domain = new RentCalculation();
        domain.setId(jpaEntity.getId());
        domain.setActionDate(jpaEntity.getActionDate());
        domain.setResults(
                jpaEntity.getResults()
                        .stream().map(this::toDomainResult)
                        .collect(toList()));
        domain.setComment(jpaEntity.getComment());

        return domain;
    }

    private RentCalculationResult toDomainResult(
            final RentCalculationResultJpaEntity calculationResult) {
        final var domain = new RentCalculationResult();
        domain.setId(calculationResult.getId());
        domain.setTransactionId(calculationResult.getTransactionId());
        domain.setLinkId(calculationResult.getLinkId());

        return domain;
    }

    @Override
    public RentCalculationJpaEntity mapToEntity(final RentCalculation domain) {
        final var entity = new RentCalculationJpaEntity();
        entity.setId(domain.getId());
        entity.setActionDate(domain.getActionDate());
        entity.setComment(domain.getComment());

        return entity;
    }
}
