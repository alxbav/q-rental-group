package ee.qrental.driver.application.port.in.usecase;

import ee.qrental.driver.application.port.in.command.DriverAddCommand;

public interface DriverAddUseCase {
    void add(DriverAddCommand driver);
}
