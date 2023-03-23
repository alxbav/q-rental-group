package ee.qrental.driver.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static java.lang.String.format;

import static java.util.Locale.getDefault;

@Getter
@Setter
@NoArgsConstructor
public class Driver {
    private static final Integer FIRST_NAME_MAX_SIZE = 15;
    private static final Integer LAST_NAME_MAX_SIZE = 30;
    private static final Integer PHONE_MAX_SIZE = 30;
    private static final Integer COMMENT_MAX_SIZE = 150;
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

    public Driver(Long id,
                  Boolean active,
                  String firstName,
                  String lastName,
                  Long isikukood,
                  String phone,
                  String email,
                  String company,
                  String regNumber,
                  String companyAddress,
                  String driverLicenseNumber,
                  LocalDate driverLicenseExp,
                  String taxiLicense,
                  String address,
                  String comment,
                  Long deposit) {
        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateComment(comment);
        this.id = id;
        this.active = active;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isikukood = isikukood;
        this.phone = phone;
        this.email = email;
        this.company = company;
        this.regNumber = regNumber;
        this.companyAddress = companyAddress;
        this.driverLicenseNumber = driverLicenseNumber;
        this.driverLicenseExp = driverLicenseExp;
        this.taxiLicense = taxiLicense;
        this.address = address;
        this.comment = comment;
        this.deposit = deposit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public void setIsikukood(Long isikukood) {
        this.isikukood = isikukood;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public void setDriverLicenseExp(LocalDate driverLicenseExp) {
        this.driverLicenseExp = driverLicenseExp;
    }

    public void setTaxiLicense(String taxiLicense) {
        this.taxiLicense = taxiLicense;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDeposit(Long deposit) { this.deposit = deposit; }

    public void setComment(String comment) {
        validateComment(comment);
        this.comment = comment;
    }

    private void validateFirstName(final String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new RuntimeException("First Name for Potential Driver must be filled!");
        }
        final var length = firstName.length();
        if (length > FIRST_NAME_MAX_SIZE) {
            throw new RuntimeException(format("First Name length for Potential Driver is %d.But must not exceed %d " +
                    "characters!", length, FIRST_NAME_MAX_SIZE));
        }
    }

    private void validateLastName(final String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new RuntimeException("Last Name for Potential Driver must be filled!");
        }
        final var length = lastName.length();
        if (length > LAST_NAME_MAX_SIZE) {
            throw new RuntimeException(format("Last Name length for Potential Driver is %d.But must not exceed %d " +
                    "characters!", length, LAST_NAME_MAX_SIZE));
        }
    }

    private void validatePhone(final String phone) {
        if (phone == null || phone.isEmpty()) {
            throw new RuntimeException("Phone for Potential Driver must be filled!");
        }
        final var length = phone.length();
        if (length > PHONE_MAX_SIZE) {
            throw new RuntimeException(format("Phone length for Potential Driver is %d.But must not exceed %d " +
                    "characters!", length, PHONE_MAX_SIZE));
        }
    }

    private void validateComment(final String comment) {
        final var length = comment.length();
        if (length > COMMENT_MAX_SIZE) {
            throw new RuntimeException(format("Comment length is %d. Comment must not exceed %d",
                    length, COMMENT_MAX_SIZE));
        }
    }
}
