package ee.qrental.transaction.application.port.in.usecase;

import ee.qrental.transaction.application.port.in.command.TransactionAddCommand;

public interface TransactionAddUseCase {
    void add(TransactionAddCommand transactionType);
}
