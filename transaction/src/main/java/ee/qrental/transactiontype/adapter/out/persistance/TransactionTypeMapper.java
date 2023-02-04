package ee.qrental.transactiontype.adapter.out.persistance;

import ee.qrental.transactiontype.domain.TransactionType;

public class TransactionTypeMapper {

    public TransactionType mapToDomain(final TransactionTypeJpaEntity jpaEntity) {
        return new TransactionType(
                jpaEntity.getId(),
                jpaEntity.getTypeTr(),
                jpaEntity.getDescription(),
                jpaEntity.getComment()
        );
    }

    public TransactionTypeJpaEntity mapToEntity(final TransactionType domain) {
        return TransactionTypeJpaEntity.builder()
                .id(domain.getId())
                .typeTr(domain.getTypeTr())
                .description(domain.getDescription())
                .comment(domain.getComment())
                .build();
    }
}
