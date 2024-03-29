package ee.qrental.driverpotential.domain;


import lombok.Getter;

import static java.lang.String.format;


@Getter
public class DriverPotential {
    private static final Integer FIRST_NAME_MAX_SIZE = 15;
    private static final Integer LAST_NAME_MAX_SIZE = 30;
    private static final Integer PHONE_MAX_SIZE = 30;
    private static final Integer COMMENT_MAX_SIZE = 150;
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

    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

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
