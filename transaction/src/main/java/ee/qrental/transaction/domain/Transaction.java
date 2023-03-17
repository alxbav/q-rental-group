package ee.qrental.transaction.domain;


import ee.qrental.common.core.utils.QTimeUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class Transaction {
    private static final Integer COMMENT_MAX_SIZE = 150;

    private Long id;

    private TransactionType type;

    private Long driverId;

    private BigDecimal amount;

    private LocalDate date;

    private String comment;
    private LocalDate dateStamp;

    public Transaction(Long id, TransactionType type, Long driverId, BigDecimal amount, LocalDate date, String comment, LocalDate dateStamp) {
        this.id = id;
        this.type = type;
        this.driverId = driverId;
        this.amount = amount;
        this.date = date;
        this.comment = comment;
        this.dateStamp = dateStamp;
    }

    public BigDecimal getRealAmount() {
        return type.getNegative() ? amount.negate() : amount;
    }

    public Integer getWeekNumber() {
        return QTimeUtils.getWeekNumber(date);
    }
}
