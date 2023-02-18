package ee.qrental.transaction.application.port.in.request;

import ee.qrental.transaction.application.port.in.utils.Week;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionFilterRequest {

    private Integer year;

    private Week week;

}
