package ee.qrental.transaction.application.service;

import ee.qrental.transaction.application.port.in.command.TransactionTypeAddCommand;
import ee.qrental.transaction.application.port.in.command.TransactionTypeUpdateCommand;
import ee.qrental.transaction.application.port.in.usecase.TransactionTypeAddUseCase;
import ee.qrental.transaction.application.port.in.usecase.TransactionTypeDeleteUseCase;
import ee.qrental.transaction.application.port.in.usecase.TransactionTypeUpdateUseCase;
import ee.qrental.transaction.application.port.out.TransactionTypeAddPort;
import ee.qrental.transaction.application.port.out.TransactionTypeDeletePort;
import ee.qrental.transaction.application.port.out.TransactionTypeLoadPort;
import ee.qrental.transaction.application.port.out.TransactionTypeUpdatePort;
import ee.qrental.transaction.domain.TransactionType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class TransactionTypeService implements
        TransactionTypeAddUseCase,
        TransactionTypeUpdateUseCase,
        TransactionTypeDeleteUseCase {

    private final TransactionTypeAddPort transactionTypeAddPort;

    private final TransactionTypeUpdatePort transactionTypeUpdatePort;

    private final TransactionTypeLoadPort transactionTypeLoadPort;

    private final TransactionTypeDeletePort transactionTypeDeletePort;

    @Override
    public void add(final TransactionTypeAddCommand command) {
        final var transactionTypeDomain = new TransactionType(
                null,
                command.getName(),
                command.getDescription(),
                command.getComment());
        transactionTypeAddPort.addTransactionType(transactionTypeDomain);
    }

    @Override
    public void update(final TransactionTypeUpdateCommand command) {
        final Long transactionTypeId = command.getId();
        final TransactionType domain = transactionTypeLoadPort.loadTransactionTypeById(transactionTypeId);
        if (domain == null) {
            throw new RuntimeException("Update of Transaction Type failed. No Transaction Type with id = " + transactionTypeId);
        }
        updateDomain(command, domain);
        transactionTypeUpdatePort.updateTransactionType(domain);
    }

    private void updateDomain(
            final TransactionTypeUpdateCommand command,
            final TransactionType toUpdate) {
        toUpdate.setName(command.getName());
        toUpdate.setDescription(command.getDescription());
        toUpdate.setComment(command.getComment());
    }

    @Override
    public void delete(Long transactionTypeId) {
        transactionTypeDeletePort.deleteTransactionType(transactionTypeId);
    }
}
