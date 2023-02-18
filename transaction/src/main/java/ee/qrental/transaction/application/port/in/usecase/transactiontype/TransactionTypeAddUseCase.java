package ee.qrental.transaction.application.port.in.usecase.transactiontype;

import ee.qrental.transaction.application.port.in.request.TransactionTypeAddRequest;

public interface TransactionTypeAddUseCase {
    void add(TransactionTypeAddRequest transactionType);
}
