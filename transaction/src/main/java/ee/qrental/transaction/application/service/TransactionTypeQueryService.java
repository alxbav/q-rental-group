package ee.qrental.transaction.application.service;

import ee.qrental.common.core.api.mapper.ResponseMapper;
import ee.qrental.transaction.application.port.in.query.GetTransactionTypeQuery;
import ee.qrental.transaction.application.port.in.request.TransactionTypeUpdateRequest;
import ee.qrental.transaction.application.port.in.response.TransactionTypeResponse;
import ee.qrental.transaction.application.port.out.TransactionTypeLoadPort;
import ee.qrental.transaction.domain.TransactionType;
import lombok.AllArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
class TransactionTypeQueryService implements GetTransactionTypeQuery {

    private final TransactionTypeLoadPort transactionTypeLoadPort;
    private final ResponseMapper<TransactionTypeUpdateRequest, TransactionTypeResponse, TransactionType> mapper;

    @Override
    public List<TransactionTypeResponse> getAll() {
        return transactionTypeLoadPort.loadAll()
                .stream()
                .map(mapper::toResponse)
                .collect(toList());
    }

    @Override
    public TransactionTypeResponse getById(final Long id) {
        return mapper.toResponse(transactionTypeLoadPort.loadById(id));
    }

    @Override
    public String getObjectInfo(Long id) {
        return mapper.toObjectInfo(transactionTypeLoadPort.loadById(id));
    }

    @Override
    public TransactionTypeUpdateRequest getUpdateRequestById(Long id) {
        return mapper.toUpdateRequest(transactionTypeLoadPort.loadById(id));
    }


}
