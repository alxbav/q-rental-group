package ee.qrental.job.application.port.in.mapper;

import ee.qrental.common.core.api.application.mapper.UpdateRequestMapper;
import ee.qrental.job.application.port.in.request.JobUpdateRequest;
import ee.qrental.job.domain.Job;
import org.springframework.stereotype.Component;

@Component
public class JobUpdateRequestMapper
        implements UpdateRequestMapper<JobUpdateRequest, Job> {

    @Override
    public Job toDomain(JobUpdateRequest request) {
        return null;
    }

    @Override
    public JobUpdateRequest toRequest(Job domain) {
        final var request = new JobUpdateRequest();
        request.setComment(domain.getComment());

        return request;
    }
}
