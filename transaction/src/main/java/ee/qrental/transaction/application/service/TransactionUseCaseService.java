package ee.qrental.transaction.application.service;

import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.transaction.application.port.in.request.TransactionAddRequest;
import ee.qrental.transaction.application.port.in.request.TransactionDeleteRequest;
import ee.qrental.transaction.application.port.in.request.TransactionUpdateRequest;
import ee.qrental.transaction.application.port.in.usecase.transaction.TransactionAddUseCase;
import ee.qrental.transaction.application.port.in.usecase.transaction.TransactionDeleteUseCase;
import ee.qrental.transaction.application.port.in.usecase.transaction.TransactionUpdateUseCase;
import ee.qrental.transaction.application.port.out.*;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
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
    public void add(final TransactionAddRequest command) {
        final var transactionType = transactionTypeLoadPort.loadById(command.getTransactionTypeId());
        final var transactionDomain = new Transaction(
                null,
                transactionType,
                command.getDriverId(),
                command.getAmount(),
                command.getDate(),
                command.getComment());
        transactionAddPort.add(transactionDomain);
    }

    @Override
    public void update(final TransactionUpdateRequest command) {
        final var id = command.getId();
        final var domain = transactionLoadPort.loadById(id);

        if (domain == null) {
            throw new RuntimeException("Update of Transaction failed. No Transaction with id = " + id);
        }
        updateDomain(command, domain);
        transactionUpdatePort.update(domain);
    }

    private void updateDomain(final TransactionUpdateRequest command,
                              final Transaction toUpdate) {

        final var type = transactionTypeLoadPort.loadById(command.getTransactionTypeId());
        toUpdate.setType(type);
        toUpdate.setDriverId(command.getDriverId());
        toUpdate.setAmount(command.getAmount());
        toUpdate.setDate(command.getDate());
        toUpdate.setComment(command.getComment());
    }

    @Override
    public void delete(TransactionDeleteRequest deleteCommand) {
        transactionDeletePort.delete(deleteCommand.getId());
    }
}
