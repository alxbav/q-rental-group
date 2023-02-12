package ee.qrental.driverpotential.application.port.in.usecase;

import ee.qrental.driverpotential.application.port.in.command.DriverPotentialDeleteCommand;

public interface DriverPotentialDeleteUseCase {
    void delete(DriverPotentialDeleteCommand deleteCommand);
}
