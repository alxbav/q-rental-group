package ee.qrental.driver.application.port.in.usecase;

import ee.qrental.driver.application.port.in.command.DriverUpdateCommand;

public interface DriverUpdateUseCase {
    void update(DriverUpdateCommand driver);
}
