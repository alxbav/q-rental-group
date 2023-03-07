package ee.qrental.car.application.port.in.request;

import ee.qrental.common.core.api.application.request.AbstractDeleteRequest;

import javax.validation.constraints.NotNull;


public class CarDeleteRequest
        extends AbstractDeleteRequest {
    public CarDeleteRequest(@NotNull Long id) {
        super(id);
    }
}