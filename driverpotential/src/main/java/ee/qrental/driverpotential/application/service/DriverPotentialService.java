package ee.qrental.driverpotential.application.service;

import ee.qrental.driverpotential.application.port.in.command.DriverPotentialAddCommand;
import ee.qrental.driverpotential.application.port.in.usecase.DriverPotentialAddUseCase;
import ee.qrental.driverpotential.application.port.in.usecase.DriverPotentialUpdateUseCase;
import ee.qrental.driverpotential.application.port.out.AddDriverPotentialPort;
import ee.qrental.driverpotential.domain.DriverPotential;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class DriverPotentialService implements
        DriverPotentialAddUseCase,
        DriverPotentialUpdateUseCase
 {

     private final AddDriverPotentialPort addDriverPotentialPort;

    @Override
    public void add(final DriverPotentialAddCommand command) {
        final var driverDomain = new DriverPotential(null, command.getFirstName(),
                command.getLastName(),
                command.getPhone(),
                Boolean.TRUE,
                command.getComment());
        addDriverPotentialPort.addDriverPotential(driverDomain);
    }

    @Override
    public void update(final DriverPotentialAddCommand command) {
       System.out.println("Driver Updated");
    }

 }
