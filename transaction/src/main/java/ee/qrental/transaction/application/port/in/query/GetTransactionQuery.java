package ee.qrental.transaction.application.port.in.query;

import ee.qrental.common.core.api.query.BaseGetQuery;
import ee.qrental.transaction.application.port.in.request.TransactionFilterRequest;
import ee.qrental.transaction.application.port.in.request.TransactionUpdateRequest;
import ee.qrental.transaction.application.port.in.response.TransactionResponse;

import java.util.List;

public interface GetTransactionQuery
        extends BaseGetQuery<TransactionUpdateRequest, TransactionResponse> {
    List<TransactionResponse> getAllByDriverId(final Long driverId);

    List<TransactionResponse> getAllByRequest(
            final TransactionFilterRequest command);

}
