package ee.qrental.driverpotential.application.service;

import ee.qrental.driverpotential.application.port.in.command.DriverPotentialAddCommand;
import ee.qrental.driverpotential.application.port.in.command.DriverPotentialUpdateCommand;
import ee.qrental.driverpotential.application.port.in.usecase.DriverPotentialAddUseCase;
import ee.qrental.driverpotential.application.port.in.usecase.DriverPotentialUpdateUseCase;
import ee.qrental.driverpotential.application.port.out.AddDriverPotentialPort;
import ee.qrental.driverpotential.application.port.out.LoadDriverPotentialPort;
import ee.qrental.driverpotential.application.port.out.UpdateDriverPotentialPort;
import ee.qrental.driverpotential.domain.DriverPotential;
import lombok.AllArgsConstructor;

import static java.lang.Boolean.TRUE;

@AllArgsConstructor
class DriverPotentialService implements
        DriverPotentialAddUseCase,
        DriverPotentialUpdateUseCase {

    private final AddDriverPotentialPort addDriverPotentialPort;

    private final UpdateDriverPotentialPort updateDriverPotentialPort;

    private final LoadDriverPotentialPort loadDriverPotentialPort;

    @Override
    public void add(final DriverPotentialAddCommand command) {
        final var driverDomain = new DriverPotential(
                null,
                command.getFirstName(),
                command.getLastName(),
                command.getPhone(),
                TRUE,
                command.getComment());
        addDriverPotentialPort.addDriverPotential(driverDomain);
    }

    @Override
    public void update(final DriverPotentialUpdateCommand command) {
        final Long potentialDriverId = command.getId();
        final DriverPotential domain = loadDriverPotentialPort.loadPotentialDriverById(potentialDriverId);
        if (domain == null) {
            throw new RuntimeException("Update of Potential Driver failed. No Potential Driver with id = " + potentialDriverId);
        }
        updateDomain(command, domain);
        updateDriverPotentialPort.updateDriverPotential(domain);
    }

    private void updateDomain(
            final DriverPotentialUpdateCommand command,
            final DriverPotential toUpdate) {
        toUpdate.setFirstName(command.getFirstName());
        toUpdate.setLastName(command.getLastName());
        toUpdate.setPhone(command.getPhone());
        toUpdate.setComment(command.getComment());
    }
}
