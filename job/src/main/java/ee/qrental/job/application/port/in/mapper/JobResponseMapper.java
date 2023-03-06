package ee.qrental.job.application.port.in.mapper;

import ee.qrental.common.core.api.application.mapper.ResponseMapper;
import ee.qrental.job.application.port.in.response.JobResponse;
import ee.qrental.job.domain.Job;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class JobResponseMapper
        implements ResponseMapper<JobResponse, Job> {

    @Override
    public JobResponse toResponse(final Job domain) {
        final var response = new JobResponse();
        response.setId(domain.getId());
        response.setComment(domain.getComment());

        return response;
    }

    @Override
    public String toObjectInfo(Job domain) {
        return format("Job for : %s and car: %s, started on: , ended on: .",
                domain.getName());
    }
}
