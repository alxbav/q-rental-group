package ee.qrental.transactiontype.application.port.in.usecase;

import ee.qrental.transactiontype.application.port.in.command.TransactionTypeAddCommand;

public interface TransactionTypeAddUseCase {
    void add(TransactionTypeAddCommand transactionType);
}
