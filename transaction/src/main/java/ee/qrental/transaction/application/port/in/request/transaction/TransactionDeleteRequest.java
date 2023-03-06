package ee.qrental.transaction.application.port.in.request.transaction;

import ee.qrental.common.core.api.application.request.AbstractDeleteRequest;

import javax.validation.constraints.NotNull;

public class TransactionDeleteRequest
        extends AbstractDeleteRequest {
    public TransactionDeleteRequest(@NotNull Long id) {
        super(id);
    }
}