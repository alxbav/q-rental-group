package ee.qrental.job.application.port.in.request;

import ee.qrental.common.core.api.request.AbstractDeleteRequest;

import javax.validation.constraints.NotNull;


public class JobDeleteRequest extends AbstractDeleteRequest {
    public JobDeleteRequest(@NotNull Long id) {
        super(id);
    }
}