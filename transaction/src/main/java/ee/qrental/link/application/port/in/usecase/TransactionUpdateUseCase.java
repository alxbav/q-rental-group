package ee.qrental.link.application.port.in.usecase;

import ee.qrental.link.application.port.in.command.TransactionUpdateCommand;

public interface TransactionUpdateUseCase {
    void update(TransactionUpdateCommand transaction);
}
