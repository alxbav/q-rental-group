package ee.qrental.transaction.application.service.transactiontype;

import ee.qrental.transaction.application.port.in.mapper.transaciontype.TransactionTypeAddRequestMapper;
import ee.qrental.transaction.application.port.in.mapper.transaciontype.TransactionTypeUpdateRequestMapper;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionTypeAddRequest;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionTypeDeleteRequest;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionTypeUpdateRequest;
import ee.qrental.transaction.application.port.in.usecase.transactiontype.TransactionTypeAddUseCase;
import ee.qrental.transaction.application.port.in.usecase.transactiontype.TransactionTypeDeleteUseCase;
import ee.qrental.transaction.application.port.in.usecase.transactiontype.TransactionTypeUpdateUseCase;
import ee.qrental.transaction.application.port.out.TransactionTypeAddPort;
import ee.qrental.transaction.application.port.out.TransactionTypeDeletePort;
import ee.qrental.transaction.application.port.out.TransactionTypeLoadPort;
import ee.qrental.transaction.application.port.out.TransactionTypeUpdatePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionTypeUseCaseService
        implements TransactionTypeAddUseCase,
        TransactionTypeUpdateUseCase,
        TransactionTypeDeleteUseCase {

    private final TransactionTypeAddPort addPort;
    private final TransactionTypeUpdatePort updatePort;
    private final TransactionTypeDeletePort deletePort;

    private final TransactionTypeLoadPort loadPort;

    private final TransactionTypeAddRequestMapper addRequestMapper;
    private final TransactionTypeUpdateRequestMapper updateRequestMapper;

    @Override
    public void add(final TransactionTypeAddRequest request) {
        addPort.add(addRequestMapper.toDomain(request));
    }

    @Override
    public void update(final TransactionTypeUpdateRequest request) {
        checkExistence(request.getId());
        updatePort.update(updateRequestMapper.toDomain(request));
    }

    @Override
    public void delete(final TransactionTypeDeleteRequest request) {
        deletePort.delete(request.getId());
    }

    private void checkExistence(final Long id) {
        if (loadPort.loadById(id) == null) {
            throw new RuntimeException("Update of Transaction Type failed. No Record with id = " + id);
        }
    }
}
