package ee.qrental.transaction.application.port.in.mapper;

import ee.qrental.common.core.api.mapper.ResponseMapper;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionTypeUpdateRequest;
import ee.qrental.transaction.application.port.in.response.transactiontype.TransactionTypeResponse;
import ee.qrental.transaction.domain.TransactionType;

import static java.lang.String.format;

public class TransactionTypeResponseMapper
        implements ResponseMapper<TransactionTypeUpdateRequest, TransactionTypeResponse, TransactionType> {
    @Override
    public TransactionTypeResponse toResponse(final TransactionType domain) {
        return TransactionTypeResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .negative(domain.getNegative())
                .description(domain.getDescription())
                .comment(domain.getComment())
                .build();
    }

    @Override
    public String toObjectInfo(TransactionType domain) {
        return format("Transaction type : %s ",
                domain.getName());
    }

    @Override
    public TransactionTypeUpdateRequest toUpdateRequest(TransactionType domain) {
        final var updateRequest = new TransactionTypeUpdateRequest();
        updateRequest.setId(domain.getId());
        updateRequest.setNegative(domain.getNegative());
        updateRequest.setName(domain.getName());
        updateRequest.setDescription(domain.getDescription());
        updateRequest.setComment(domain.getComment());

        return updateRequest;
    }
}
