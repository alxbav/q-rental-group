package ee.qrental.transaction.application.port.in.request.transaction;

import ee.qrental.common.core.api.application.request.AbstractAddRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class TransactionAddRequest
        extends AbstractAddRequest {
    private Long transactionTypeId;
    private Long driverId;
    private Long amount;
    private Integer weekNumber;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date = LocalDate.now();
    private String comment;
}

