package ee.qrental.transaction.application.service;

import ee.qrental.transaction.application.port.in.command.TransactionAddCommand;
import ee.qrental.transaction.application.port.in.command.TransactionUpdateCommand;
import ee.qrental.transaction.application.port.in.usecase.TransactionAddUseCase;
import ee.qrental.transaction.application.port.in.usecase.TransactionDeleteUseCase;
import ee.qrental.transaction.application.port.in.usecase.TransactionUpdateUseCase;
import ee.qrental.transaction.application.port.out.*;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class TransactionService implements TransactionAddUseCase, TransactionUpdateUseCase, TransactionDeleteUseCase {

   ;

    private final TransactionAddPort transactionAddPort;

    private final TransactionUpdatePort transactionUpdatePort;

    private final TransactionLoadPort transactionLoadPort;

    private final TransactionDeletePort transactionDeletePort;
    private final TransactionTypeLoadPort transactionTypeLoadPort;
    @Override
    public void add(final TransactionAddCommand command) {
        final var transactionType = transactionTypeLoadPort.loadTransactionTypeById(command.getTransactionTypeId());

        final var transactionDomain = new Transaction(
                null,
                transactionType,
                command.getDriverId(),
                command.getAmount(),
                command.getWeekNumber(),
                command.getDate(),
                command.getComment());
        transactionAddPort.addTransaction(transactionDomain);
    }

    @Override
    public void update(final TransactionUpdateCommand command) {
        final var id = command.getId();
        final var domain = transactionLoadPort.loadTransactionById(id);

        if (domain == null) {
            throw new RuntimeException("Update of Transaction failed. No Transaction with id = " + id);
        }
        updateDomain(command, domain);
        transactionUpdatePort.updateTransaction(domain);
    }

    private void updateDomain(final TransactionUpdateCommand command, final Transaction toUpdate) {

        final var type = transactionTypeLoadPort.loadTransactionTypeById(command.getTransactionTypeId());
        toUpdate.setType(type);
        toUpdate.setDriverId(command.getDriverId());
        toUpdate.setAmount(command.getAmount());
        toUpdate.setWeekNumber(command.getWeekNumber());
        toUpdate.setDate(command.getDate());
        toUpdate.setComment(command.getComment());
    }

    @Override
    public void delete(Long transactionId) {
        transactionDeletePort.deleteTransaction(transactionId);
    }
}
