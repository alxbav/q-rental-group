package ee.qrental.transaction.application.service.transaction;

import ee.qrental.transaction.application.port.in.mapper.transaction.TransactionAddRequestMapper;
import ee.qrental.transaction.application.port.in.mapper.transaction.TransactionUpdateRequestMapper;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionAddRequest;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionDeleteRequest;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionUpdateRequest;
import ee.qrental.transaction.application.port.in.usecase.transaction.TransactionAddUseCase;
import ee.qrental.transaction.application.port.in.usecase.transaction.TransactionDeleteUseCase;
import ee.qrental.transaction.application.port.in.usecase.transaction.TransactionUpdateUseCase;
import ee.qrental.transaction.application.port.out.TransactionAddPort;
import ee.qrental.transaction.application.port.out.TransactionDeletePort;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.application.port.out.TransactionUpdatePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionUseCaseService implements
        TransactionAddUseCase,
        TransactionUpdateUseCase,
        TransactionDeleteUseCase {

    private final TransactionAddPort transactionAddPort;
    private final TransactionUpdatePort transactionUpdatePort;
    private final TransactionLoadPort transactionLoadPort;
    private final TransactionDeletePort transactionDeletePort;

    private final TransactionAddRequestMapper addRequestMapper;
    private final TransactionUpdateRequestMapper updateRequestMapper;

    @Override
    public void add(final TransactionAddRequest request) {
        transactionAddPort.add(addRequestMapper.toDomain(request));
    }

    @Override
    public void update(final TransactionUpdateRequest request) {
        checkExistence(request.getId());
        transactionUpdatePort.update(updateRequestMapper.toDomain(request));
    }

    private void checkExistence(final Long id) {
        if (transactionLoadPort.loadById(id) == null) {
            throw new RuntimeException("Update of Transaction failed. No Transaction with id = " + id);
        }
    }

    @Override
    public void delete(final TransactionDeleteRequest request) {
        transactionDeletePort.delete(request.getId());
    }
}
