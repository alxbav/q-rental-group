package ee.qrental.transaction.application.port.in.request.firm;

import ee.qrental.common.core.api.request.AbstractDeleteRequest;

import javax.validation.constraints.NotNull;

public class FirmDeleteRequest extends AbstractDeleteRequest {
    public FirmDeleteRequest(@NotNull Long id) {
        super(id);
    }
}