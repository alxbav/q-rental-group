package ee.qrental.driverpotential.application.service;

import ee.qrental.driverpotential.application.port.in.command.DriverPotentialAddCommand;
import ee.qrental.driverpotential.application.port.in.command.DriverPotentialDeleteCommand;
import ee.qrental.driverpotential.application.port.in.command.DriverPotentialUpdateCommand;
import ee.qrental.driverpotential.application.port.in.usecase.DriverPotentialAddUseCase;
import ee.qrental.driverpotential.application.port.in.usecase.DriverPotentialDeleteUseCase;
import ee.qrental.driverpotential.application.port.in.usecase.DriverPotentialUpdateUseCase;
import ee.qrental.driverpotential.application.port.out.DriverPotentialAddPort;
import ee.qrental.driverpotential.application.port.out.DriverPotentialDeletePort;
import ee.qrental.driverpotential.application.port.out.DriverPotentialLoadPort;
import ee.qrental.driverpotential.application.port.out.DriverPotentialUpdatePort;
import ee.qrental.driverpotential.domain.DriverPotential;
import lombok.AllArgsConstructor;

import static java.lang.Boolean.TRUE;

@AllArgsConstructor
class DriverPotentialService implements
        DriverPotentialAddUseCase,
        DriverPotentialUpdateUseCase,
        DriverPotentialDeleteUseCase {

    private final DriverPotentialAddPort driverPotentialAddPort;

    private final DriverPotentialUpdatePort driverPotentialUpdatePort;

    private final DriverPotentialLoadPort driverPotentialLoadPort;

    private final DriverPotentialDeletePort driverPotentialDeletePort;

    @Override
    public void add(final DriverPotentialAddCommand command) {
        final var driverPotentialDomain = new DriverPotential(
                null,
                command.getFirstName(),
                command.getLastName(),
                command.getPhone(),
                TRUE,
                command.getComment());
        driverPotentialAddPort.addDriverPotential(driverPotentialDomain);
    }

    @Override
    public void update(final DriverPotentialUpdateCommand command) {
        final Long potentialDriverId = command.getId();
        final DriverPotential domain = driverPotentialLoadPort.loadPotentialDriverById(potentialDriverId);
        if (domain == null) {
            throw new RuntimeException("Update of Potential Driver failed. No Potential Driver with id = " + potentialDriverId);
        }
        updateDomain(command, domain);
        driverPotentialUpdatePort.updateDriverPotential(domain);
    }

    private void updateDomain(
            final DriverPotentialUpdateCommand command,
            final DriverPotential toUpdate) {
        toUpdate.setFirstName(command.getFirstName());
        toUpdate.setLastName(command.getLastName());
        toUpdate.setPhone(command.getPhone());
        toUpdate.setComment(command.getComment());
    }

    @Override
    public void delete(DriverPotentialDeleteCommand deleteCommand) {
        driverPotentialDeletePort.deleteDriverPotential(deleteCommand.getId());
    }
}
