package ee.qrental.transaction.application.port.in.usecase;

import ee.qrental.transaction.application.port.in.command.TransactionTypeDeleteCommand;

public interface TransactionTypeDeleteUseCase {
    void delete(TransactionTypeDeleteCommand deleteCommand);
}

