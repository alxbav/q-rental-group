package ee.qrental.transaction.application.port.in.query;

import ee.qrental.transaction.application.port.in.response.balance.BalanceResponse;

import java.math.BigDecimal;
import java.util.List;

public interface GetBalanceQuery {
    List<BalanceResponse> getAll();

    BigDecimal getTotalByDriverId(final Long driverId);

}
