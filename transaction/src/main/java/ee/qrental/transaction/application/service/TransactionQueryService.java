package ee.qrental.transaction.application.service;

import ee.qrental.common.core.api.mapper.ResponseMapper;
import ee.qrental.transaction.application.port.in.query.GetTransactionQuery;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionFilterRequest;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionUpdateRequest;
import ee.qrental.transaction.application.port.in.response.transaction.TransactionResponse;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.application.service.strategy.TransactionLoadStrategy;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@AllArgsConstructor
class TransactionQueryService implements GetTransactionQuery {

    private final TransactionLoadPort transactionLoadPort;
    private final List<TransactionLoadStrategy> loadStrategies;
    private final ResponseMapper<TransactionUpdateRequest, TransactionResponse, Transaction> mapper;

    @Override
    public List<TransactionResponse> getAll() {
        return mapToTransactionResponseList(transactionLoadPort.loadAll());
    }

    @Override
    public TransactionResponse getById(final Long id) {
        return mapper.toResponse(transactionLoadPort.loadById(id));
    }

    @Override
    public String getObjectInfo(final Long id) {
        return mapper.toObjectInfo(transactionLoadPort.loadById(id));
    }

    @Override
    public List<TransactionResponse> getAllByDriverId(final Long driverId) {
        return mapToTransactionResponseList(transactionLoadPort.loadAllByDriverId(driverId));
    }

    @Override
    public List<TransactionResponse> getAllByFilterRequest(final TransactionFilterRequest request) {
        return mapToTransactionResponseList(
                loadStrategies.stream()
                        .filter(strategy -> strategy.canApply(request))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("No Load Strategy was found for the request: " + request))
                        .load(request));
    }

    @Override
    public TransactionUpdateRequest getUpdateRequestById(Long id) {
        return mapper.toUpdateRequest(transactionLoadPort.loadById(id));
    }

    private List<TransactionResponse> mapToTransactionResponseList(final List<Transaction> transactions) {
        return transactions.stream().map(mapper::toResponse).sorted(comparing(TransactionResponse::getDate)).collect(toList());
    }
}
