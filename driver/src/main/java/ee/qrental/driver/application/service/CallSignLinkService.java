package ee.qrental.driver.application.service;

import ee.qrental.driver.application.port.in.command.CallSignAddCommand;
import ee.qrental.driver.application.port.in.command.DriverAddCommand;
import ee.qrental.driver.application.port.in.command.DriverUpdateCommand;
import ee.qrental.driver.application.port.in.usecase.CallSignLinkAddUseCase;
import ee.qrental.driver.application.port.in.usecase.DriverAddUseCase;
import ee.qrental.driver.application.port.in.usecase.DriverDeleteUseCase;
import ee.qrental.driver.application.port.in.usecase.DriverUpdateUseCase;
import ee.qrental.driver.application.port.out.*;
import ee.qrental.driver.domain.CallSignLink;
import ee.qrental.driver.domain.Driver;
import lombok.AllArgsConstructor;

import static java.lang.Boolean.TRUE;

@AllArgsConstructor
class CallSignLinkService implements
        CallSignLinkAddUseCase {

    private final CallSignLinkAddPort callSignLinkAddPort;

    @Override
    public void add(final CallSignAddCommand command) {
        final var domain = new CallSignLink(
                null,
                command.getCallSign(),
                command.getDriverId(),
                command.getDateStart(),
                command.getDateEnd(),
                command.getComment());
        callSignLinkAddPort.addCallSignLink(domain);
    }

  /*  @Override
    public void update(final DriverUpdateCommand command) {
        final Long driverId = command.getId();
        final Driver domain = driverLoadPort.loadDriverById(driverId);
        if (domain == null) {
            throw new RuntimeException("Update of Driver failed. No Driver with id = " + driverId);
        }
        updateDomain(command, domain);
        driverUpdatePort.updateDriver(domain);
    }*/

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

/*    @Override
    public void delete(Long driverId) {
        driverDeletePort.deleteDriver(driverId);
    }*/
}
