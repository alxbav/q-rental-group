package ee.qrental.driver.application.port.in.request.driver;


import ee.qrental.common.core.api.application.request.AbstractDeleteRequest;

import javax.validation.constraints.NotNull;

public class DriverDeleteRequest extends AbstractDeleteRequest {
    public DriverDeleteRequest(@NotNull final Long id) {
        super(id);
    }
}