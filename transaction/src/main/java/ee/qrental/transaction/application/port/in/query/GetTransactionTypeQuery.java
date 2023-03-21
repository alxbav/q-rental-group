package ee.qrental.transaction.application.port.in.query;

import ee.qrental.common.core.api.application.query.BaseGetQuery;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionTypeUpdateRequest;
import ee.qrental.transaction.application.port.in.response.transactiontype.TransactionTypeResponse;

import java.util.List;

public interface GetTransactionTypeQuery
        extends BaseGetQuery<TransactionTypeUpdateRequest, TransactionTypeResponse> {

    TransactionTypeResponse getByName(final String name);

    List<TransactionTypeResponse> getByNegative(final boolean negative);
}
