package ee.qrental.transaction.adapter.out.persistance;

import ee.qrental.transaction.domain.Transaction;

public class TransactionMapper {

    public Transaction mapToDomain(final TransactionJpaEntity jpaEntity) {
        return new Transaction(
                jpaEntity.getId(),
                jpaEntity.getTypeTr(),
                jpaEntity.getDescription(),
                jpaEntity.getComment()
        );
    }

    public TransactionJpaEntity mapToEntity(final Transaction domain) {
        return TransactionJpaEntity.builder()
                .id(domain.getId())
                .typeTr(domain.getTypeTr())
                .description(domain.getDescription())
                .comment(domain.getComment())
                .build();
    }
}
