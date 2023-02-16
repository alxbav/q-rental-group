package ee.qrental.transaction.application.port.in.usecase;

import ee.qrental.transaction.application.port.in.command.ConstantDeleteCommand;
import ee.qrental.transaction.domain.Constant;

public interface ConstantDeleteUseCase {
    void delete(ConstantDeleteCommand deleteCommand);
}

