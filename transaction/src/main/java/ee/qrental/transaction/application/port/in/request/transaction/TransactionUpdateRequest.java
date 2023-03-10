package ee.qrental.transaction.application.port.in.request.transaction;

import ee.qrental.common.core.api.application.request.AbstractUpdateRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class TransactionUpdateRequest
        extends AbstractUpdateRequest {

    private Long transactionTypeId;
    private Long driverId;
    private Long amount;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;
    private String comment;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateStamp = LocalDate.now();
}