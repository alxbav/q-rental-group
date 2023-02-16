package ee.qrental.transaction.adapter.out.persistance.mapper;

import ee.qrental.transaction.adapter.out.persistance.jpaentity.ConstantJpaEntity;
import ee.qrental.transaction.domain.Constant;

public class ConstantMapper {

    public Constant mapToDomain(final ConstantJpaEntity jpaEntity) {
        return new Constant(
                jpaEntity.getId(),
                jpaEntity.getName(),
                jpaEntity.getValue(),
                jpaEntity.getDescription(),
                jpaEntity.getNegative()
        );
    }

    public ConstantJpaEntity mapToEntity(final Constant domain) {
        return ConstantJpaEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .value(domain.getValue())
                .description(domain.getDescription())
                .negative(domain.getNegative())
                .build();
    }
}
