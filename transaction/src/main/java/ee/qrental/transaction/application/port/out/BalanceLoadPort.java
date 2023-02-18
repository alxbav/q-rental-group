package ee.qrental.transaction.application.port.out;

import ee.qrental.transaction.application.port.in.response.BalanceResponse;

import java.util.List;

public interface BalanceLoadPort {
    List<BalanceResponse> loadBalances();
}
