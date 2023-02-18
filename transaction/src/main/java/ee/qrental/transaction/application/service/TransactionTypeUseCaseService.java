package ee.qrental.transaction.application.service;

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
    public void add(final TransactionTypeAddRequest request) {
        final var transactionTypeDomain = new TransactionType(
                null,
                request.getName(),
                request.getDescription(),
                request.getNegative(),
                request.getComment());
        transactionTypeAddPort.add(transactionTypeDomain);
    }

    @Override
    public void update(final TransactionTypeUpdateRequest request) {
        final var transactionTypeId = request.getId();
        final var domain = transactionTypeLoadPort.loadById(transactionTypeId);
        if (domain == null) {
            throw new RuntimeException("Update of Transaction Type failed. No Transaction Type with id = "
                    + transactionTypeId);
        }
        updateDomain(request, domain);
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
    public void delete(final TransactionTypeDeleteRequest request) {
        transactionTypeDeletePort.delete(request.getId());
    }
}
