package ee.qrental.transaction.application.port.in.response.balance;

import ee.qrental.transaction.application.port.in.response.transaction.TransactionResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BalanceDetailResponse {

    private Long total;

    private String driverInfo;

    private List<TransactionResponse> transactions;
}
