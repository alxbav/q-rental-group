package ee.qrental.transaction.application.service;

import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionAddRequest;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionDeleteRequest;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionUpdateRequest;
import ee.qrental.transaction.application.port.in.usecase.transaction.TransactionAddUseCase;
import ee.qrental.transaction.application.port.in.usecase.transaction.TransactionDeleteUseCase;
import ee.qrental.transaction.application.port.in.usecase.transaction.TransactionUpdateUseCase;
import ee.qrental.transaction.application.port.out.*;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class TransactionUseCaseService implements
        TransactionAddUseCase,
        TransactionUpdateUseCase,
        TransactionDeleteUseCase {

    private final TransactionAddPort transactionAddPort;
    private final TransactionUpdatePort transactionUpdatePort;
    private final TransactionLoadPort transactionLoadPort;
    private final TransactionDeletePort transactionDeletePort;
    private final TransactionTypeLoadPort transactionTypeLoadPort;

    private final DriverLoadPort driverLoadPort;
    @Override
    public void add(final TransactionAddRequest request) {
        final var transactionType = transactionTypeLoadPort.loadById(request.getTransactionTypeId());
        final var domain = new Transaction(
                null,
                transactionType,
                request.getDriverId(),
                request.getAmount(),
                request.getDate(),
                request.getComment());
        transactionAddPort.add(domain);
    }

    @Override
    public void update(final TransactionUpdateRequest request) {
        final var id = request.getId();
        final var domain = transactionLoadPort.loadById(id);

        if (domain == null) {
            throw new RuntimeException("Update of Transaction failed. No Transaction with id = " + id);
        }
        updateDomain(request, domain);
        transactionUpdatePort.update(domain);
    }

    private void updateDomain(final TransactionUpdateRequest request,
                              final Transaction toUpdate) {
        final var type = transactionTypeLoadPort.loadById(request.getTransactionTypeId());
        toUpdate.setType(type);
        toUpdate.setDriverId(request.getDriverId());
        toUpdate.setAmount(request.getAmount());
        toUpdate.setDate(request.getDate());
        toUpdate.setComment(request.getComment());
    }

    @Override
    public void delete(final TransactionDeleteRequest request) {
        transactionDeletePort.delete(request.getId());
    }
}
