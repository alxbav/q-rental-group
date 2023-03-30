package ee.qrental.transaction.application.port.in.request.invoice;

import ee.qrental.common.core.api.application.request.AbstractDeleteRequest;

import javax.validation.constraints.NotNull;

public class InvoiceDeleteRequest
        extends AbstractDeleteRequest {
    public InvoiceDeleteRequest(@NotNull Long id) {
        super(id);
    }
}