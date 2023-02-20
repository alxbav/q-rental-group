package ee.qrental.transaction.adapter.out.persistance.mapper;

import ee.qrental.transaction.adapter.out.persistance.jpaentity.FirmJpaEntity;
import ee.qrental.transaction.domain.Firm;

public class FirmMapper {

    public Firm mapToDomain(final FirmJpaEntity jpaEntity) {
        return new Firm(
                jpaEntity.getId(),
                jpaEntity.getName(),
                jpaEntity.getIban(),
                jpaEntity.getRegNumber(),
                jpaEntity.getVatNumber(),
                jpaEntity.getComment()
        );
    }

    public FirmJpaEntity mapToEntity(final Firm domain) {
        return FirmJpaEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .iban(domain.getIban())
                .regNumber(domain.getRegNumber())
                .vatNumber(domain.getVatNumber())
                .comment(domain.getComment())
                .build();
    }
}
