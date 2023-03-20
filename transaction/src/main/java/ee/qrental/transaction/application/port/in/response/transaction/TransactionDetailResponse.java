package ee.qrental.transaction.application.port.in.response.transaction;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@SuperBuilder
public class TransactionDetailResponse {
    private Long id;
    private String typeId;
    private String driverId;

    private Long amount;
    private Integer weekNumber;
    private LocalDate date;
    private String comment;
    private LocalDate dateStamp;
}
