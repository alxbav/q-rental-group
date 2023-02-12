package ee.qrental.driver.application.port.in.usecase;

import ee.qrental.driver.application.port.in.command.DriverDeleteCommand;

public interface DriverDeleteUseCase {
    void delete(DriverDeleteCommand deleteCommand);
}
