package ee.qrental.transaction.application.port.in.usecase;

import ee.qrental.transaction.application.port.in.command.TransactionDeleteCommand;

public interface TransactionDeleteUseCase {
    void delete(TransactionDeleteCommand deleteCommand);
}

