package ee.qrental.transaction.domain;


import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static java.lang.String.format;

@Getter
@Setter
@NoArgsConstructor

public class Firm {

    private static final Integer COMMENT_MAX_SIZE = 150;
    private Long id;
    private String name;
    private String iban;
    private Long regNumber;
    private String vatNumber;
    private String comment;
    private String eMail;
    private String postAddress;
    private String phone;
    private String bank;
    private Boolean qGroup;

    public Firm(Long id, String name, String iban, Long regNumber,
                String vatNumber, String comment, String eMail,
                String postAddress, String phone, String bank,
                Boolean qGroup) {
        this.id = id;
        this.name = name;
        this.iban = iban;
        this.regNumber = regNumber;
        this.vatNumber = vatNumber;
        this.comment = comment;
        this.eMail = eMail;
        this.postAddress = postAddress;
        this.phone = phone;
        this.bank = bank;
        this.qGroup = qGroup;
    }

    private void validateComment(final String comment) {
        final var length = comment.length();
        if (length > COMMENT_MAX_SIZE) {
            throw new RuntimeException(format("Comment length is %d. Comment must not exceed %d",
                    length, COMMENT_MAX_SIZE));
        }
    }


}
