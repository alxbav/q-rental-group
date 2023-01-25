package ee.qrental.driverpotential.application.port.in.usecase;

import ee.qrental.driverpotential.application.port.in.command.DriverPotentialAddCommand;
import ee.qrental.driverpotential.application.port.in.command.DriverPotentialUpdateCommand;

public interface DriverPotentialUpdateUseCase {
    void update(DriverPotentialUpdateCommand driver);
}
