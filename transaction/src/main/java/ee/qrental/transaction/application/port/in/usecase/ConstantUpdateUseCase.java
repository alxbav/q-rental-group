package ee.qrental.transaction.application.port.in.usecase;

import ee.qrental.transaction.application.port.in.command.ConstantUpdateCommand;

public interface ConstantUpdateUseCase {
    void update(ConstantUpdateCommand constant);
}
