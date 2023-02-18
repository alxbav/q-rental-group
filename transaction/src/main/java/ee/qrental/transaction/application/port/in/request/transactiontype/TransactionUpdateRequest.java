package ee.qrental.transaction.application.port.in.request.transactiontype;

import ee.qrental.common.core.api.request.AbstractUpdateRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class TransactionUpdateRequest extends AbstractUpdateRequest {
    private Long transactionTypeId;
    private Long driverId;
    private Long amount;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;
    private String comment;

}