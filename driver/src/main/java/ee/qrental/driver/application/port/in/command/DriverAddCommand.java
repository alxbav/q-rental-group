package ee.qrental.driver.application.port.in.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class DriverAddCommand {

    private String firstName;
    private String lastName;
    private String isikukood;
    private String phone;
    private String email;
    private String iban1;
    private String iban2;
    private String iban3;
    private String driverLicenseNumber;
    private Date driverLicenseExp;
    private String taxiLicense;
    private String address;
    private String comment;

}