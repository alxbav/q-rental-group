package ee.qrental.transaction.application.port.in.request.transactiontype;

import ee.qrental.common.core.api.application.request.AbstractDeleteRequest;

import javax.validation.constraints.NotNull;

public class TransactionTypeDeleteRequest
        extends AbstractDeleteRequest {

    public TransactionTypeDeleteRequest(@NotNull Long id) {
        super(id);
    }
}