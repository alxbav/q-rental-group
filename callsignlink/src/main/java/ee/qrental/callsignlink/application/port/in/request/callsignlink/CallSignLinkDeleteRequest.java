package ee.qrental.callsignlink.application.port.in.request.callsignlink;

import ee.qrental.common.core.api.application.request.AbstractDeleteRequest;

import javax.validation.constraints.NotNull;


public class CallSignLinkDeleteRequest
        extends AbstractDeleteRequest {
    public CallSignLinkDeleteRequest(@NotNull Long id) {
        super(id);
    }
}