package ee.qrental.transaction.application.port.in.usecase.transactiontype;

import ee.qrental.transaction.application.port.in.request.TransactionTypeUpdateRequest;

public interface TransactionTypeUpdateUseCase {
    void update(TransactionTypeUpdateRequest transactionType);
}
