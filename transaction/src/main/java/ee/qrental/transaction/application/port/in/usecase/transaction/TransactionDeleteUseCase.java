package ee.qrental.transaction.application.port.in.usecase.transaction;

import ee.qrental.transaction.application.port.in.request.TransactionDeleteRequest;

public interface TransactionDeleteUseCase {
    void delete(TransactionDeleteRequest deleteCommand);
}

