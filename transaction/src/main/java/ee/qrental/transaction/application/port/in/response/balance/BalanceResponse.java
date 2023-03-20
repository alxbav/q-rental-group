package ee.qrental.transaction.application.port.in.response.balance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalanceResponse {
    private Long driverId;
    private Integer callSign;
    private String firstName;
    private String lastName;
    private Long total;
}
