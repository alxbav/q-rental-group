package ee.qrental.driver.application.port.in.mapper.driver;


import ee.qrental.common.core.api.application.mapper.ResponseMapper;
import ee.qrental.driver.application.port.in.response.driver.DriverResponse;
import ee.qrental.driver.domain.Driver;
import org.springframework.stereotype.Component;

import static java.lang.String.format;
@Component
public class DriverResponseMapper
        implements ResponseMapper<DriverResponse, Driver> {
    @Override
    public DriverResponse toResponse(final Driver domain) {
        return DriverResponse.builder()
                .id(domain.getId())
                .active(domain.getActive())
                .firstName(domain.getFirstName())
                .lastName(domain.getLastName())
                .isikukood(domain.getIsikukood())
                .phone(domain.getPhone())
                .email(domain.getEmail())
                .company(domain.getCompany())
                .regNumber(domain.getRegNumber())
                .companyAddress(domain.getCompanyAddress())
                .driverLicenseNumber(domain.getDriverLicenseNumber())
                .driverLicenseExp(domain.getDriverLicenseExp())
                .taxiLicense(domain.getTaxiLicense())
                .address(domain.getAddress())
                .comment(domain.getComment())
                .deposit(domain.getDeposit())
                .build();
    }

    @Override
    public String toObjectInfo(Driver domain) {
        return format("%s %s",
                domain.getLastName(),
                domain.getFirstName());
    }
}
