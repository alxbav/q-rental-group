package ee.qrental.driver.application.port.in.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class DriverUpdateCommand {

    private Long id;
    private String firstName;
    private String lastName;
    private Long isikukood;
    private String phone;
    private String email;
    private String iban1;
    private String iban2;
    private String iban3;
    private String driverLicenseNumber;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate driverLicenseExp;
    private String taxiLicense;
    private String address;
    private String comment;

}