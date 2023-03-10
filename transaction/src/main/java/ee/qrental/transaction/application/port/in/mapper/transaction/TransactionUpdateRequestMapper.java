package ee.qrental.transaction.application.port.in.mapper.transaction;

import ee.qrental.common.core.api.application.mapper.UpdateRequestMapper;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionUpdateRequest;
import ee.qrental.transaction.application.port.out.TransactionTypeLoadPort;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionUpdateRequestMapper
        implements UpdateRequestMapper<TransactionUpdateRequest, Transaction> {

    private final TransactionTypeLoadPort typeLoadPort;

    @Override
    public Transaction toDomain(TransactionUpdateRequest request) {
        final var domain = new Transaction();
        final var type = typeLoadPort.loadById(request.getTransactionTypeId());
        domain.setId(request.getId());
        domain.setType(type);
        domain.setDriverId(request.getDriverId());
        domain.setAmount(request.getAmount());
        domain.setDate(request.getDate());
        domain.setComment(request.getComment());
        domain.setDateStamp(request.getDateStamp());

        return domain;
    }

    @Override
    public TransactionUpdateRequest toRequest(Transaction domain) {
        final var request = new TransactionUpdateRequest();
        request.setId(domain.getId());
        request.setTransactionTypeId(domain.getType().getId());
        request.setAmount(domain.getAmount());
        request.setDriverId(domain.getDriverId());
        request.setDate(domain.getDate());
        request.setComment(domain.getComment());
        request.setDateStamp(domain.getDateStamp());

        return request;
    }
}
