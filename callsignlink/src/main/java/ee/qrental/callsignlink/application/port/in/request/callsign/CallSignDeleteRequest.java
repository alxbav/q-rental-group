package ee.qrental.callsignlink.application.port.in.request.callsign;

import ee.qrental.common.core.api.application.request.AbstractDeleteRequest;

import javax.validation.constraints.NotNull;


public class CallSignDeleteRequest
        extends AbstractDeleteRequest {

    public CallSignDeleteRequest(@NotNull Long id) {
        super(id);
    }
}