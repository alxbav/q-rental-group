package ee.qrental.job.application.port.in.query;

import ee.qrental.common.core.api.application.query.BaseGetQuery;
import ee.qrental.job.application.port.in.request.JobUpdateRequest;
import ee.qrental.job.application.port.in.response.JobResponse;

public interface GetJobQuery
        extends BaseGetQuery<JobUpdateRequest, JobResponse> {
}