package ee.qrental.job.application.port.in.mapper;


import ee.qrental.common.core.api.application.mapper.AddRequestMapper;
import ee.qrental.job.application.port.in.request.JobAddRequest;
import ee.qrental.job.domain.Job;
import org.springframework.stereotype.Component;

@Component
public class JobAddRequestMapper
        implements AddRequestMapper<JobAddRequest, Job> {
    @Override
    public Job toDomain(final JobAddRequest request) {
        //TODO
        return null;
    }
}
