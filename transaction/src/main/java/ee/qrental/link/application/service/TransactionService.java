package ee.qrental.link.application.service;

import ee.qrental.link.application.port.in.command.TransactionAddCommand;
import ee.qrental.link.application.port.in.usecase.TransactionAddUseCase;
import ee.qrental.link.application.port.out.TransactionDeletePort;
import ee.qrental.link.application.port.in.command.TransactionUpdateCommand;
import ee.qrental.link.application.port.in.usecase.TransactionDeleteUseCase;
import ee.qrental.link.application.port.in.usecase.TransactionUpdateUseCase;
import ee.qrental.link.application.port.out.TransactionAddPort;
import ee.qrental.link.application.port.out.TransactionLoadPort;
import ee.qrental.link.application.port.out.TransactionUpdatePort;
import ee.qrental.link.domain.Transaction;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class TransactionService implements
        TransactionAddUseCase,
        TransactionUpdateUseCase,
        TransactionDeleteUseCase {

    private final TransactionAddPort transactionAddPort;

    private final TransactionUpdatePort transactionUpdatePort;

    private final TransactionLoadPort transactionLoadPort;

    private final TransactionDeletePort transactionDeletePort;

    @Override
    public void add(final TransactionAddCommand command) {
        final var transactionDomain = new Transaction(
                null,
                command.getTransactionTypeId(),
                command.getDriverId(),
                command.getAmount(),
                command.getWeekNumber(),
                command.getDate(),
                command.getComment());
        transactionAddPort.addTransaction(transactionDomain);
    }

    @Override
    public void update(final TransactionUpdateCommand command) {
        final Long transactionId = command.getId();
        final Transaction domain = transactionLoadPort.loadTransactionById(transactionId);
        if (domain == null) {
            throw new RuntimeException("Update of Transaction Type failed. No Transaction Type with id = " + transactionId);
        }
        updateDomain(command, domain);
        transactionUpdatePort.updateTransaction(domain);
    }

    private void updateDomain(
            final TransactionUpdateCommand command,
            final Transaction toUpdate) {
        toUpdate.setTransactionTypeId(command.getTransactionTypeId());
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
