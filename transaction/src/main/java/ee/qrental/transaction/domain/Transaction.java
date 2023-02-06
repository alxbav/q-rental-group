package ee.qrental.transaction.domain;


import lombok.Getter;

import java.time.LocalDate;

import static java.lang.String.format;


@Getter
public class Transaction {


    private static final Integer COMMENT_MAX_SIZE = 150;
    private Long id;
    private TransactionType type;
    private Long driverId;
    private Long amount;
    private Integer weekNumber;
    private LocalDate date;
    private String comment;

    public Transaction(Long id,
                       TransactionType type,
                       Long driverId,
                       Long amount,
                       Integer weekNumber,
                       LocalDate date,
                       String comment) {

        validateComment(comment);
        this.id = id;
        this.type = type;
        this.driverId = driverId;
        this.amount = amount;
        this.weekNumber = weekNumber;
        this.date = date;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public Long getDriverId() {
        return driverId;
    }

    public Long getAmount() {
        return amount;
    }

    public Integer getWeekNumber() {
        return weekNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getComment() {
        return comment;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setWeekNumber(Integer weekNumber) {
        this.weekNumber = weekNumber;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
