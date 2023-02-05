package ee.qrental.link.application.port.in.usecase;

import ee.qrental.link.application.port.in.command.TransactionAddCommand;

public interface TransactionAddUseCase {
    void add(TransactionAddCommand transaction);
}
