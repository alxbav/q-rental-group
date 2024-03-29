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
public class TransactionUseCaseService
        implements TransactionAddUseCase,
        TransactionUpdateUseCase,
        TransactionDeleteUseCase {

    private final TransactionAddPort addPort;
    private final TransactionUpdatePort updatePort;
    private final TransactionDeletePort deletePort;
    private final TransactionLoadPort loadPort;
    private final TransactionAddRequestMapper addRequestMapper;
    private final TransactionUpdateRequestMapper updateRequestMapper;

    @Override
    public Long add(final TransactionAddRequest request) {
        return addPort.add(addRequestMapper.toDomain(request)).getId();
    }

    @Override
    public void update(final TransactionUpdateRequest request) {
        checkExistence(request.getId());
        updatePort.update(updateRequestMapper.toDomain(request));
    }

    private void checkExistence(final Long id) {
        if (loadPort.loadById(id) == null) {
            throw new RuntimeException("Update of Transaction failed. No Transaction with id = " + id);
        }
    }

    @Override
    public void delete(final TransactionDeleteRequest request) {
        deletePort.delete(request.getId());
    }
}
