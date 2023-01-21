package ee.qrental.driverpotential.domain;


import lombok.Getter;

import static java.lang.String.format;


@Getter
public class DriverPotential {
    private static final Integer FIRST_NAME_MAX_SIZE = 15;
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private Boolean active;
    private String comment;


    public DriverPotential(Long id,
                           String firstName,
                           String lastName,
                           String phone,
                           Boolean active,
                           String comment) {
        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateComment(comment);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.active = active;
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
        //TODO ..
    }
    private void validatePhone(final String phone) {
        //TODO ..
    }
    private void validateComment(final String comment) {
        //TODO ..
    }
}
