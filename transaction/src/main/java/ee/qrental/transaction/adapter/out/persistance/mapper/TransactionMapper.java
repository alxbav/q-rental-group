package ee.qrental.transaction.adapter.out.persistance.mapper;

import ee.qrental.transaction.adapter.out.persistance.jpaentity.TransactionJpaEntity;
import ee.qrental.transaction.adapter.out.persistance.jpaentity.TransactionTypeJpaEntity;
import ee.qrental.transaction.domain.Transaction;
import ee.qrental.transaction.domain.TransactionType;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public Transaction mapToDomain(final TransactionJpaEntity jpaEntity) {
        final var jpaEntityTransactionType = jpaEntity.getType();
        final var type = new TransactionType(
                jpaEntityTransactionType.getId(),
                jpaEntityTransactionType.getName(),
                jpaEntityTransactionType.getDescription(),
                jpaEntityTransactionType.getNegative(),
                jpaEntity.getComment());

        return new Transaction(jpaEntity.getId(),
                type,
                jpaEntity.getDriverId(),
                jpaEntity.getAmount(),
                jpaEntity.getDate(),
                jpaEntity.getComment(),
                jpaEntity.getDateStamp());
    }

    public TransactionJpaEntity mapToEntity(final Transaction domain) {
        final var transactionTypeJpaEntity = TransactionTypeJpaEntity.builder()
                .id(domain.getType().getId())
                .name(domain.getType().getName())
                .description(domain.getType().getDescription())
                .negative(domain.getType().getNegative())
                .comment(domain.getType().getComment())
                .build();

        return TransactionJpaEntity.builder()
                .id(domain.getId())
                .type(transactionTypeJpaEntity)
                .driverId(domain.getDriverId())
                .amount(domain.getAmount())
                .date(domain.getDate())
                .comment(domain.getComment())
                .dateStamp(domain.getDateStamp())
                .build();
    }
}
