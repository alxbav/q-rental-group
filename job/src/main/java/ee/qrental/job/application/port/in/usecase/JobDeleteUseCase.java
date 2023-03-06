package ee.qrental.job.application.port.in.usecase;

import ee.qrental.common.core.api.application.usecase.DeleteUseCase;
import ee.qrental.job.application.port.in.request.JobDeleteRequest;

public interface JobDeleteUseCase
        extends DeleteUseCase<JobDeleteRequest> {
}