package ee.qrental.transaction.domain;


import lombok.Getter;

import static java.lang.String.format;


@Getter
public class TransactionType {

    private static final Integer COMMENT_MAX_SIZE = 150;
    private Long id;
    private String name;
    private String description;
    private Boolean negative;
    private String comment;

    public TransactionType(Long id,
                           String typeTr,
                           String description,
                           Boolean negative,
                           String comment) {
        validateComment(comment);
        validateNegative(negative);
        this.id = id;
        this.name = typeTr;
        this.description = description;
        this.negative = negative;
        this.comment = comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNegative(Boolean negative) {
        validateNegative(negative);
        this.negative = negative;
    }

    public void setComment(String comment) {
        validateComment(comment);
        this.comment = comment;
    }

    private void validateComment(final String comment) {
        final var length = comment.length();
        if (length > COMMENT_MAX_SIZE) {
            throw new RuntimeException(format("Comment length is %d. Comment must not exceed %d",
                    length, COMMENT_MAX_SIZE));
        }
    }
    private void validateNegative(final Boolean negative) {
        if (negative == null) {
            throw new RuntimeException("Transaction Type property 'negative' must not be NULL. Value must be TRUE or FALSE");
        }
    }

}
