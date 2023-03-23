package ee.qrental.driver.application.port.in.request.driver;


import ee.qrental.common.core.api.application.request.AbstractUpdateRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class DriverUpdateRequest
        extends AbstractUpdateRequest {
    private Boolean active;
    private String firstName;
    private String lastName;
    private Long isikukood;
    private String phone;
    private String email;
    private String company;
    private String regNumber;
    private String companyAddress;
    private String driverLicenseNumber;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate driverLicenseExp;
    private String taxiLicense;
    private String address;
    private String comment;
    private Long deposit;
}