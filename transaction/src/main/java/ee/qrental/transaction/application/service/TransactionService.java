package ee.qrental.transaction.application.service;

import ee.qrental.transaction.application.port.in.command.TransactionAddCommand;
import ee.qrental.transaction.application.port.in.usecase.TransactionAddUseCase;
import ee.qrental.transaction.application.port.out.TransactionDeletePort;
import lombok.AllArgsConstructor;
import ee.qrental.transaction.application.port.in.command.TransactionUpdateCommand;
import ee.qrental.transaction.application.port.in.usecase.TransactionDeleteUseCase;
import ee.qrental.transaction.application.port.in.usecase.TransactionUpdateUseCase;
import ee.qrental.transaction.application.port.out.TransactionAddPort;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.application.port.out.TransactionUpdatePort;
import ee.qrental.transaction.domain.Transaction;

@AllArgsConstructor
class TransactionService implements
        TransactionAddUseCase,
        TransactionUpdateUseCase,
        TransactionDeleteUseCase {

    private final TransactionAddPort transactionTypeAddPort;

    private final TransactionUpdatePort transactionTypeUpdatePort;

    private final TransactionLoadPort transactionTypeLoadPort;

    private final TransactionDeletePort transactionTypeDeletePort;

    @Override
    public void add(final TransactionAddCommand command) {
        final var transactionTypeDomain = new Transaction(
                null,
                command.getTypeTr(),
                command.getDescription(),
                command.getComment());
        transactionTypeAddPort.addTransactionType(transactionTypeDomain);
    }

    @Override
    public void update(final TransactionUpdateCommand command) {
        final Long transactionTypeId = command.getId();
        final Transaction domain = transactionTypeLoadPort.loadTransactionTypeById(transactionTypeId);
        if (domain == null) {
            throw new RuntimeException("Update of Transaction Type failed. No Transaction Type with id = " + transactionTypeId);
        }
        updateDomain(command, domain);
        transactionTypeUpdatePort.updateTransactionType(domain);
    }

    private void updateDomain(
            final TransactionUpdateCommand command,
            final Transaction toUpdate) {
        toUpdate.setTypeTr(command.getTypeTr());
        toUpdate.setDescription(command.getDescription());
        toUpdate.setComment(command.getComment());
    }

    @Override
    public void delete(Long transactionTypeId) {
        transactionTypeDeletePort.deleteTransactionType(transactionTypeId);
    }
}
