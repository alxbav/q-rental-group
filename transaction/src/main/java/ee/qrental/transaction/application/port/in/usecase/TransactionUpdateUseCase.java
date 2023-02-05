package ee.qrental.transaction.application.port.in.usecase;

import ee.qrental.transaction.application.port.in.command.TransactionUpdateCommand;

public interface TransactionUpdateUseCase {
    void update(TransactionUpdateCommand transaction);
}
