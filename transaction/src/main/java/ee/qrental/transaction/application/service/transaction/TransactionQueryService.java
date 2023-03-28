package ee.qrental.transaction.application.service.transaction;

import ee.qrental.transaction.application.port.in.mapper.transaction.TransactionResponseMapper;
import ee.qrental.transaction.application.port.in.mapper.transaction.TransactionUpdateRequestMapper;
import ee.qrental.transaction.application.port.in.query.GetTransactionQuery;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionFilterRequest;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionUpdateRequest;
import ee.qrental.transaction.application.port.in.response.transaction.TransactionResponse;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.application.service.transaction.strategy.TransactionLoadStrategy;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@Service

@AllArgsConstructor
public class TransactionQueryService
        implements GetTransactionQuery {

    private final TransactionLoadPort transactionLoadPort;
    private final List<TransactionLoadStrategy> loadStrategies;
    private final TransactionResponseMapper responseMapper;
    private final TransactionUpdateRequestMapper updateRequestMapper;

    @Override
    public List<TransactionResponse> getAll() {
        return mapToTransactionResponseList(transactionLoadPort.loadAll());
    }

    @Override
    public TransactionResponse getById(final Long id) {
        return responseMapper.toResponse(transactionLoadPort.loadById(id));
    }

    @Override
    public String getObjectInfo(final Long id) {
        return responseMapper.toObjectInfo(transactionLoadPort.loadById(id));
    }

    @Override
    public List<TransactionResponse> getAllByDriverId(final Long driverId) {
        return mapToTransactionResponseList(transactionLoadPort.loadAllByDriverId(driverId));
    }

    @Override
    public List<TransactionResponse> getAllByCalculationId(Long calculationId) {
        return mapToTransactionResponseList(transactionLoadPort.loadAllByCalculationId(calculationId));
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
        return updateRequestMapper.toRequest(transactionLoadPort.loadById(id));
    }

    private List<TransactionResponse> mapToTransactionResponseList(final List<Transaction> transactions) {
        return transactions.stream().map(responseMapper::toResponse).sorted(comparing(TransactionResponse::getDate).reversed()).collect(toList());
    }
}
