package ee.qrental.transaction.application.port.in.usecase.transaction;

import ee.qrental.transaction.application.port.in.request.TransactionAddRequest;

public interface TransactionAddUseCase {
    void add(TransactionAddRequest transaction);
}
