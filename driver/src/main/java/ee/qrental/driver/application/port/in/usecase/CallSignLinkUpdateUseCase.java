package ee.qrental.driver.application.port.in.usecase;

import ee.qrental.driver.application.port.in.command.CallSignLinkUpdateCommand;
import ee.qrental.driver.application.port.in.command.DriverUpdateCommand;

public interface CallSignLinkUpdateUseCase {
    void update(CallSignLinkUpdateCommand callSignLink);
}
