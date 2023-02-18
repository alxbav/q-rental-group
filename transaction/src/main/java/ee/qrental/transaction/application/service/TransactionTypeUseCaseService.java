package ee.qrental.transaction.application.service;

import ee.qrental.transaction.application.port.in.request.TransactionTypeAddRequest;
import ee.qrental.transaction.application.port.in.request.TransactionTypeDeleteRequest;
import ee.qrental.transaction.application.port.in.request.TransactionTypeUpdateRequest;
import ee.qrental.transaction.application.port.in.usecase.transactiontype.TransactionTypeAddUseCase;
import ee.qrental.transaction.application.port.in.usecase.transactiontype.TransactionTypeDeleteUseCase;
import ee.qrental.transaction.application.port.in.usecase.transactiontype.TransactionTypeUpdateUseCase;
import ee.qrental.transaction.application.port.out.TransactionTypeAddPort;
import ee.qrental.transaction.application.port.out.TransactionTypeDeletePort;
import ee.qrental.transaction.application.port.out.TransactionTypeLoadPort;
import ee.qrental.transaction.application.port.out.TransactionTypeUpdatePort;
import ee.qrental.transaction.domain.TransactionType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class TransactionTypeUseCaseService implements
        TransactionTypeAddUseCase,
        TransactionTypeUpdateUseCase,
        TransactionTypeDeleteUseCase {

    private final TransactionTypeAddPort transactionTypeAddPort;

    private final TransactionTypeUpdatePort transactionTypeUpdatePort;

    private final TransactionTypeLoadPort transactionTypeLoadPort;

    private final TransactionTypeDeletePort transactionTypeDeletePort;

    @Override
    public void add(final TransactionTypeAddRequest command) {
        final var transactionTypeDomain = new TransactionType(
                null,
                command.getName(),
                command.getDescription(),
                command.getNegative(),
                command.getComment());
        transactionTypeAddPort.add(transactionTypeDomain);
    }

    @Override
    public void update(final TransactionTypeUpdateRequest command) {
        final Long transactionTypeId = command.getId();
        final TransactionType domain = transactionTypeLoadPort.loadById(transactionTypeId);
        if (domain == null) {
            throw new RuntimeException("Update of Transaction Type failed. No Transaction Type with id = " + transactionTypeId);
        }
        updateDomain(command, domain);
        transactionTypeUpdatePort.update(domain);
    }

    private void updateDomain(
            final TransactionTypeUpdateRequest request,
            final TransactionType toUpdate) {
        toUpdate.setName(request.getName());
        toUpdate.setDescription(request.getDescription());
        toUpdate.setNegative(request.getNegative());
        toUpdate.setComment(request.getComment());
    }

    @Override
    public void delete(TransactionTypeDeleteRequest deleteCommand) {
        transactionTypeDeletePort.delete(deleteCommand.getId());
    }

}
