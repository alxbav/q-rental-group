package ee.qrental.transaction.application.port.in.usecase;

import ee.qrental.transaction.application.port.in.command.ConstantAddCommand;

public interface ConstantAddUseCase {
    void add(ConstantAddCommand constant);
}
