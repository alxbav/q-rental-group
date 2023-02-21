package ee.qrental.transaction.application.port.in.query;

import ee.qrental.transaction.application.port.in.response.balance.BalanceResponse;

import java.util.List;

public interface GetBalanceQuery {
    List<BalanceResponse> getAll();

    Long getTotalByDriverId(final Long driverId);

}
