package ee.qrental.transaction.application.port.in.request.transaction;

import ee.qrental.transaction.application.port.in.utils.Week;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TransactionFilterRequest {
    private Integer year;
    private Week week;
    private Long driverId;
}
