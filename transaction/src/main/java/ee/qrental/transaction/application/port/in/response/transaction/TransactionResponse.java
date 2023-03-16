package ee.qrental.transaction.application.port.in.response.transaction;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@SuperBuilder
public class TransactionResponse {
    private Long id;
    private String type;
    private String driverInfo;
    private Integer callSign;
    private BigDecimal realAmount;
    private Integer weekNumber;
    private LocalDate date;
    private LocalDate dateStamp;
    private String comment;
}
