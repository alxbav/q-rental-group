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
        domain.setCompany(request.getCompany());
        domain.setRegNumber(request.getRegNumber());
        domain.setCompanyAddress(request.getCompanyAddress());
        domain.setDriverLicenseNumber(request.getDriverLicenseNumber());
        domain.setDriverLicenseExp(request.getDriverLicenseExp());
        domain.setTaxiLicense(request.getTaxiLicense());
        domain.setAddress(request.getAddress());
        domain.setComment(request.getComment());
        domain.setDeposit(request.getDeposit());

        return domain;
    }
}
