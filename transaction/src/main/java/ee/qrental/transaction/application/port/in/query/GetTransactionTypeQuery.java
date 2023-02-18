package ee.qrental.transaction.application.port.in.query;

import ee.qrental.common.core.api.query.BaseGetQuery;
import ee.qrental.transaction.application.port.in.request.TransactionTypeUpdateRequest;
import ee.qrental.transaction.application.port.in.response.TransactionTypeResponse;

public interface GetTransactionTypeQuery
        extends BaseGetQuery<TransactionTypeUpdateRequest, TransactionTypeResponse> {

}
