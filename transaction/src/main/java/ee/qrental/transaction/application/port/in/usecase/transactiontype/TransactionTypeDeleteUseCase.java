package ee.qrental.transaction.application.port.in.usecase.transactiontype;

import ee.qrental.transaction.application.port.in.request.TransactionTypeDeleteRequest;

public interface TransactionTypeDeleteUseCase {
    void delete(TransactionTypeDeleteRequest deleteCommand);
}

