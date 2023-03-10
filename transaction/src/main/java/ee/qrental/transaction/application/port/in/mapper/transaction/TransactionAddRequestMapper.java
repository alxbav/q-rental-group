package ee.qrental.transaction.application.port.in.mapper.transaction;

import ee.qrental.common.core.api.application.mapper.AddRequestMapper;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionAddRequest;
import ee.qrental.transaction.application.port.out.TransactionTypeLoadPort;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionAddRequestMapper
        implements AddRequestMapper<TransactionAddRequest, Transaction> {

    private final TransactionTypeLoadPort transactionTypeLoadPort;

    @Override
    public Transaction toDomain(TransactionAddRequest request) {
        final var domain = new Transaction();
        domain.setId(null);
        domain.setType(transactionTypeLoadPort.loadById(request.getTransactionTypeId()));
        domain.setAmount(request.getAmount());
        domain.setDriverId(request.getDriverId());
        domain.setDate(request.getDate());
        domain.setComment(request.getComment());
        domain.setDateStamp(request.getDateStamp());

        return domain;
    }
}