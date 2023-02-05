package ee.qrental.link.adapter.out.persistance;

import ee.qrental.link.domain.Transaction;

public class TransactionMapper {

    public Transaction mapToDomain(final TransactionJpaEntity jpaEntity) {
        return new Transaction(
                jpaEntity.getId(),
                jpaEntity.getTransactionTypeId(),
                jpaEntity.getDriverId(),
                jpaEntity.getAmount(),
                jpaEntity.getWeekNumber(),
                jpaEntity.getDate(),
                jpaEntity.getComment()
        );
    }


    public TransactionJpaEntity mapToEntity(final Transaction domain) {
        return TransactionJpaEntity.builder()
                .id(domain.getId())
                .transactionTypeId(domain.getTransactionTypeId())
                .driverId(domain.getDriverId())
                .amount(domain.getAmount())
                .weekNumber(domain.getWeekNumber())
                .date(domain.getDate())
                .comment(domain.getComment())
                .build();
    }
}
