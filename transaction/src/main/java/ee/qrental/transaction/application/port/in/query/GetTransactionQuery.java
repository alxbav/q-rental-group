package ee.qrental.transaction.application.port.in.query;

import ee.qrental.common.core.api.query.BaseGetQuery;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionFilterRequest;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionUpdateRequest;
import ee.qrental.transaction.application.port.in.response.transaction.TransactionResponse;

import java.util.List;

public interface GetTransactionQuery
        extends BaseGetQuery<TransactionUpdateRequest, TransactionResponse> {
    List<TransactionResponse> getAllByDriverId(final Long driverId);

    List<TransactionResponse> getAllByRequest(
            final TransactionFilterRequest command);

}
