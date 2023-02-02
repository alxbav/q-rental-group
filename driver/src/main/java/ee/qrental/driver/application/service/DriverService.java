package ee.qrental.driver.application.service;

import ee.qrental.driver.application.port.in.command.DriverAddCommand;
import ee.qrental.driver.application.port.in.command.DriverUpdateCommand;
import ee.qrental.driver.application.port.in.usecase.DriverAddUseCase;
import ee.qrental.driver.application.port.in.usecase.DriverDeleteUseCase;
import ee.qrental.driver.application.port.in.usecase.DriverUpdateUseCase;
import ee.qrental.driver.application.port.out.DriverAddPort;
import ee.qrental.driver.application.port.out.DriverDeletePort;
import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.driver.application.port.out.DriverUpdatePort;
import ee.qrental.driver.domain.Driver;
import lombok.AllArgsConstructor;

import static java.lang.Boolean.TRUE;

@AllArgsConstructor
class DriverService implements
        DriverAddUseCase,
        DriverUpdateUseCase,
        DriverDeleteUseCase {

    private final DriverAddPort driverAddPort;

    private final DriverUpdatePort driverUpdatePort;

    private final DriverLoadPort driverLoadPort;

    private final DriverDeletePort driverDeletePort;

    @Override
    public void add(final DriverAddCommand command) {
        final var driverDomain = new Driver(
                null,
                TRUE,
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
        driverAddPort.addDriver(driverDomain);
    }

    @Override
    public void update(final DriverUpdateCommand command) {
        final Long driverId = command.getId();
        final Driver domain = driverLoadPort.loadDriverById(driverId);
        if (domain == null) {
            throw new RuntimeException("Update of Driver failed. No Driver with id = " + driverId);
        }
        updateDomain(command, domain);
        driverUpdatePort.updateDriver(domain);
    }

    private void updateDomain(
            final DriverUpdateCommand command,
            final Driver toUpdate) {
        toUpdate.setFirstName(command.getFirstName());
        toUpdate.setLastName(command.getLastName());
        toUpdate.setIsikukood(command.getIsikukood());
        toUpdate.setPhone(command.getPhone());
        toUpdate.setEmail(command.getEmail());
        toUpdate.setIban1(command.getIban1());
        toUpdate.setIban2(command.getIban2());
        toUpdate.setIban3(command.getIban3());
        toUpdate.setDriverLicenseNumber(command.getDriverLicenseNumber());
        toUpdate.setDriverLicenseExp(command.getDriverLicenseExp());
        toUpdate.setTaxiLicense(command.getTaxiLicense());
        toUpdate.setAddress(command.getAddress());
        toUpdate.setComment(command.getComment());
    }

    @Override
    public void delete(Long driverId) {
        driverDeletePort.deleteDriver(driverId);
    }
}
