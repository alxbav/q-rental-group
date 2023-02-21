package ee.qrental.transaction.domain;


import lombok.Getter;

import static java.lang.String.format;


@Getter
public class Firm {

    private static final Integer COMMENT_MAX_SIZE = 150;
    private Long id;
    private String name;
    private String iban;

    private Long regNumber;
    private String vatNumber;
    private String comment;

    public Firm(Long id, String name, String iban, Long regNumber, String vatNumber, String comment) {
        this.id = id;
        this.name = name;
        this.iban = iban;
        this.regNumber = regNumber;
        this.vatNumber = vatNumber;
        this.comment = comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setRegNumber(Long regNumber) {
        this.regNumber = regNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private void validateComment(final String comment) {
        final var length = comment.length();
        if (length > COMMENT_MAX_SIZE) {
            throw new RuntimeException(format("Comment length is %d. Comment must not exceed %d",
                    length, COMMENT_MAX_SIZE));
        }
    }


}