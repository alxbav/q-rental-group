package ee.qrental.driver.application.port.in.usecase;

import ee.qrental.driver.application.port.in.command.CallSignLinkDeleteCommand;

public interface CallSignLinkDeleteUseCase {
    void delete(CallSignLinkDeleteCommand deleteCommand);
}

