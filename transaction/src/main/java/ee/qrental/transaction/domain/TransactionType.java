package ee.qrental.transaction.domain;


import lombok.Getter;

import static java.lang.String.format;


@Getter
public class TransactionType {

    private static final Integer COMMENT_MAX_SIZE = 150;
    private Long id;
    private String name;
    private String description;
    private String comment;

    public TransactionType(Long id,
                           String typeTr,
                           String description,
                           String comment) {

        validateComment(comment);
        this.id = id;
        this.name = typeTr;
        this.description = description;
        this.comment = comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
