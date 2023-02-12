package ee.qrental.driver.application.port.in.usecase;

import ee.qrental.driver.application.port.in.command.CallSignLinkAddCommand;

public interface CallSignLinkAddUseCase {
    void add(CallSignLinkAddCommand addCommand);
}
