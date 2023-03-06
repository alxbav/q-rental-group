package ee.qrental.driver.application.port.in.mapper.driver;

import ee.qrental.common.core.api.mapper.UpdateRequestMapper;
import ee.qrental.driver.application.port.in.request.driver.DriverUpdateRequest;
import ee.qrental.driver.domain.Driver;
import org.springframework.stereotype.Component;

@Component
public class DriverUpdateRequestMapper
        implements UpdateRequestMapper<DriverUpdateRequest, Driver> {

    @Override
    public Driver toDomain(final DriverUpdateRequest request) {
        final var domain = new Driver();
        domain.setId(request.getId());
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

    @Override
    public DriverUpdateRequest toRequest(final Driver domain) {
        final var request = new DriverUpdateRequest();
        request.setId(domain.getId());
        request.setActive(domain.getActive());
        request.setFirstName(domain.getFirstName());
        request.setLastName(domain.getLastName());
        request.setIsikukood(domain.getIsikukood());
        request.setPhone(domain.getPhone());
        request.setEmail(domain.getEmail());
        request.setIban1(domain.getIban1());
        request.setIban2(domain.getIban2());
        request.setIban3(domain.getIban3());
        request.setDriverLicenseNumber(domain.getDriverLicenseNumber());
        request.setDriverLicenseExp(domain.getDriverLicenseExp());
        request.setTaxiLicense(domain.getTaxiLicense());
        request.setAddress(domain.getAddress());
        request.setComment(domain.getComment());

        return request;
    }
}
