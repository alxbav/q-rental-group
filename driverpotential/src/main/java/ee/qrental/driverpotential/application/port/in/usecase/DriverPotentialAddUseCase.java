package ee.qrental.driverpotential.application.port.in.usecase;

import ee.qrental.driverpotential.application.port.in.command.DriverPotentialAddCommand;

public interface DriverPotentialAddUseCase {
    void add(DriverPotentialAddCommand driver);
}
