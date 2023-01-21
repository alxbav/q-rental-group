package ee.qrental.driverpotential.application.port.in.usecase;

import ee.qrental.driverpotential.application.port.in.command.DriverPotentialAddCommand;

public interface DriverPotentialUpdateUseCase {
    void update(DriverPotentialAddCommand driver);
}
