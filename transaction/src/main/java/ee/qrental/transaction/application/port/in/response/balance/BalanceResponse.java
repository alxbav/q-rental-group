package ee.qrental.transaction.application.port.in.response.balance;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BalanceResponse {
    private Long driverId;
    private Integer callSign;
    private String firstName;
    private String lastName;
    private BigDecimal total;
}
