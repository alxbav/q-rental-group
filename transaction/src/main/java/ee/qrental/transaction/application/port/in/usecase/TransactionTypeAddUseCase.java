package ee.qrental.transaction.application.port.in.usecase;

import ee.qrental.transaction.application.port.in.command.TransactionTypeAddCommand;

public interface TransactionTypeAddUseCase {
    void add(TransactionTypeAddCommand transactionType);
}
