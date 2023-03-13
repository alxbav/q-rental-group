package ee.qrental.transaction.adapter.out.persistance.mapper;

import ee.qrental.transaction.adapter.out.persistance.jpaentity.FirmJpaEntity;
import ee.qrental.transaction.domain.Firm;
import org.springframework.stereotype.Component;

@Component
public class FirmMapper {

    public Firm mapToDomain(final FirmJpaEntity jpaEntity) {
        return new Firm(
                jpaEntity.getId(),
                jpaEntity.getName(),
                jpaEntity.getIban(),
                jpaEntity.getRegNumber(),
                jpaEntity.getVatNumber(),
                jpaEntity.getComment(),
                jpaEntity.getEmail(),
                jpaEntity.getPostAddress(),
                jpaEntity.getPhone(),
                jpaEntity.getBank(),
                jpaEntity.getQGroup()
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
                .email(domain.getEMail())
                .postAddress(domain.getPostAddress())
                .phone(domain.getPhone())
                .bank(domain.getBank())
                .qGroup(domain.getQGroup())
                .build();
    }
}
