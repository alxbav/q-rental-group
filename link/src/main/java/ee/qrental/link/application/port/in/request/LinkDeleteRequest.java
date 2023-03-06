package ee.qrental.link.application.port.in.request;

import ee.qrental.common.core.api.application.request.AbstractDeleteRequest;

import javax.validation.constraints.NotNull;


public class LinkDeleteRequest
        extends AbstractDeleteRequest {

    public LinkDeleteRequest(@NotNull Long id) {
        super(id);
    }
}