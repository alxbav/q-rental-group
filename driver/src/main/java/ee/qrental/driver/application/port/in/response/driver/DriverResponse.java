package ee.qrental.driver.application.port.in.response.driver;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@Getter
@Setter
public class DriverResponse {
    private Long id;
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
    private LocalDate driverLicenseExp;
    private String taxiLicense;
    private String address;
    private String comment;
    private Long deposit;
}
