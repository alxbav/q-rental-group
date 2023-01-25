package ee.qrental.driver.application.service;

import ee.qrental.driver.application.port.in.command.DriverAddCommand;
import ee.qrental.driver.application.port.in.usecase.DriverAddUseCase;
import ee.qrental.driver.application.port.in.usecase.DriverUpdateUseCase;
import ee.qrental.driver.application.port.out.AddDriverPort;
import ee.qrental.driver.domain.Driver;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class DriverService implements
        DriverAddUseCase,
        DriverUpdateUseCase
 {

     private final AddDriverPort addDriverPort;

    @Override
    public void add(final DriverAddCommand command) {
        final var driverDomain = new Driver(null,
                Boolean.TRUE,
                command.getFirstName(),
                command.getLastName(),
                command.getIsikukood(),
                command.getPhone(),
                command.getEmail(),
                command.getIban1(),
                command.getIban2(),
                command.getIban3(),
                command.getDriverLicenseNumber(),
                command.getDriverLicenseExp(),
                command.getTaxiLicense(),
                command.getAddress(),
                command.getComment());
        addDriverPort.addDriver(driverDomain);
    }

    @Override
    public void update(final DriverAddCommand command) {
       System.out.println("Driver Updated");
    }

 }
