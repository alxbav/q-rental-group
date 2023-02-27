package ee.qrental.transaction.application.port.in.mapper.transaciontype;

import ee.qrental.common.core.api.mapper.ResponseMapper;
import ee.qrental.transaction.application.port.in.response.transactiontype.TransactionTypeResponse;
import ee.qrental.transaction.domain.TransactionType;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class TransactionTypeResponseMapper
        implements ResponseMapper<TransactionTypeResponse, TransactionType> {
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
}
