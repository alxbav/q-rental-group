package ee.qrental.driver.application.port.in.usecase;

import ee.qrental.driver.application.port.in.command.CallSignAddCommand;

public interface CallSignLinkAddUseCase {
    void add(CallSignAddCommand addCommand);
}
