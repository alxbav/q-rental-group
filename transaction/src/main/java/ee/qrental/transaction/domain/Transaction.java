package ee.qrental.transaction.domain;


import ee.qrental.common.core.utils.QTimeUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class Transaction {
    private static final Integer COMMENT_MAX_SIZE = 150;

    private Long id;

    private TransactionType type;

    private Long driverId;

    private Long amount;

    private LocalDate date;

    private String comment;
    private LocalDate dateStamp;

    public Transaction(Long id, TransactionType type, Long driverId, Long amount, LocalDate date, String comment, LocalDate dateStamp) {
        this.id = id;
        this.type = type;
        this.driverId = driverId;
        this.amount = amount;
        this.date = date;
        this.comment = comment;
        this.dateStamp = dateStamp;
    }

    public Long getRealAmount() {
        return type.getNegative() ? -amount : amount;
    }

    public Integer getWeekNumber() {
        return QTimeUtils.getWeekNumber(date);
    }
}
