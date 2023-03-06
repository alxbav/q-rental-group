package ee.qrental.driver.application.port.in.request.driver;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class DriverAddRequest {
    private Boolean active;
    private String firstName;
    private String lastName;
    private Long isikukood;
    private String phone;
    private String email;
    private String iban1;
    private String iban2;
    private String iban3;
    private String driverLicenseNumber;
    private LocalDate driverLicenseExp;
    private String taxiLicense;
    private String address;
    private String comment;

}