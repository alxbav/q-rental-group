package ee.qrental.transaction.application.port.in.usecase.transaction;

import ee.qrental.transaction.application.port.in.request.TransactionUpdateRequest;

public interface TransactionUpdateUseCase {
    void update(TransactionUpdateRequest transaction);
}
