package ee.qrental.transaction.adapter.out.persistance.mapper;

import ee.qrental.transaction.adapter.out.persistance.jpaentity.TransactionTypeJpaEntity;
import ee.qrental.transaction.domain.TransactionType;

public class TransactionTypeMapper {

    public TransactionType mapToDomain(final TransactionTypeJpaEntity jpaEntity) {
        return new TransactionType(
                jpaEntity.getId(),
                jpaEntity.getName(),
                jpaEntity.getDescription(),
                jpaEntity.getNegative(),
                jpaEntity.getComment()
        );
    }

    public TransactionTypeJpaEntity mapToEntity(final TransactionType domain) {
        return TransactionTypeJpaEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .negative(domain.getNegative())
                .comment(domain.getComment())
                .build();
    }
}
