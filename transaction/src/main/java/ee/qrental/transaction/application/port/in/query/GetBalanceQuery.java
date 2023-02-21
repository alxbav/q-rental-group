package ee.qrental.transaction.application.port.in.query;

import ee.qrental.transaction.application.port.in.request.transaction.TransactionWeekAndDriverFilterRequest;
import ee.qrental.transaction.application.port.in.response.balance.BalanceDetailResponse;
import ee.qrental.transaction.application.port.in.response.balance.BalanceResponse;

import java.util.List;

public interface GetBalanceQuery {
    List<BalanceResponse> getAll();

    BalanceDetailResponse getDetailedBalanceByDriverId(
            final Long driverId
    );

    BalanceDetailResponse getDetailedBalanceBySearchRequest(
            final TransactionWeekAndDriverFilterRequest searchRequest);
}
