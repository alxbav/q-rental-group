package ee.qrental.transaction.application.port.in.usecase;

import ee.qrental.transaction.application.port.in.command.TransactionTypeUpdateCommand;

public interface TransactionTypeUpdateUseCase {
    void update(TransactionTypeUpdateCommand transactionType);
}
