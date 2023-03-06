package ee.qrental.driver.application.port.in.mapper.driver;


import ee.qrental.common.core.api.application.mapper.AddRequestMapper;
import ee.qrental.driver.application.port.in.request.driver.DriverAddRequest;
import ee.qrental.driver.domain.Driver;
import org.springframework.stereotype.Component;

@Component
public class DriverAddRequestMapper
        implements AddRequestMapper<DriverAddRequest, Driver> {

    @Override
    public Driver toDomain(DriverAddRequest request) {
        final var domain = new Driver();
        domain.setId(null);
        domain.setActive(request.getActive());
        domain.setFirstName(request.getFirstName());
        domain.setLastName(request.getLastName());
        domain.setIsikukood(request.getIsikukood());
        domain.setPhone(request.getPhone());
        domain.setEmail(request.getEmail());
        domain.setIban1(request.getIban1());
        domain.setIban2(request.getIban2());
        domain.setIban3(request.getIban3());
        domain.setDriverLicenseNumber(request.getDriverLicenseNumber());
        domain.setDriverLicenseExp(request.getDriverLicenseExp());
        domain.setTaxiLicense(request.getTaxiLicense());
        domain.setAddress(request.getAddress());
        domain.setComment(request.getComment());

        return domain;
    }
}
