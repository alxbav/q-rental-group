package ee.qrental.transactiontype.application.port.in.usecase;

import ee.qrental.transactiontype.application.port.in.command.TransactionTypeUpdateCommand;

public interface TransactionTypeUpdateUseCase {
    void update(TransactionTypeUpdateCommand transactionType);
}
