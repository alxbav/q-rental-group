package ee.qrental.transaction.application.port.in.mapper.transaciontype;

import ee.qrental.common.core.api.mapper.AddRequestMapper;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionTypeAddRequest;
import ee.qrental.transaction.domain.TransactionType;
import org.springframework.stereotype.Component;

@Component
public class TransactionTypeAddRequestMapper implements
        AddRequestMapper<TransactionTypeAddRequest, TransactionType> {

    @Override
    public TransactionType toDomain(TransactionTypeAddRequest request) {
        final var domain = new TransactionType();
        domain.setId(null);
        domain.setName(request.getName());
        domain.setNegative(request.getNegative());
        domain.setDescription(request.getDescription());
        domain.setComment(request.getComment());

        return domain;
    }
}
