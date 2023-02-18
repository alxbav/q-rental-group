package ee.qrental.transaction.application.port.in.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class TransactionAddRequest {
    private Long transactionTypeId;
    private Long driverId;
    private Long amount;
    private Integer weekNumber;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date = LocalDate.now();
    private String comment;
}

