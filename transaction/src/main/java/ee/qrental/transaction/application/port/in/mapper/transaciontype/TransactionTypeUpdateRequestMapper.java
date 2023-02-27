package ee.qrental.transaction.application.port.in.mapper.transaciontype;

import ee.qrental.common.core.api.mapper.UpdateRequestMapper;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionTypeUpdateRequest;
import ee.qrental.transaction.domain.TransactionType;
import org.springframework.stereotype.Component;

@Component
public class TransactionTypeUpdateRequestMapper
        implements UpdateRequestMapper<TransactionTypeUpdateRequest, TransactionType> {

    @Override
    public TransactionType toDomain(final TransactionTypeUpdateRequest request) {
        final var domain = new TransactionType();
        domain.setId(request.getId());
        domain.setNegative(request.getNegative());
        domain.setDescription(request.getDescription());
        domain.setComment(request.getComment());

        return domain;
    }

    @Override
    public TransactionTypeUpdateRequest toRequest(final TransactionType domain) {
        final var request = new TransactionTypeUpdateRequest();
        request.setId(domain.getId());
        request.setName(domain.getName());
        request.setNegative(domain.getNegative());
        request.setDescription(domain.getDescription());
        request.setComment(domain.getComment());

        return request;
    }
}
