package ee.qrental.transaction.application.port.in.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class BalanceResponse {
    private Long driverId;
    private String firstName;
    private String lastName;
    private String plateNumber;
    private String callSign;
    private Long amount;
}
