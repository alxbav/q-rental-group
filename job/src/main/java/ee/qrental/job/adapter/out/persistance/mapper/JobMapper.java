package ee.qrental.job.adapter.out.persistance.mapper;

import ee.qrental.common.core.api.adapter.mapper.DomainMapper;
import ee.qrental.job.adapter.out.persistance.jpaentity.JobJpaEntity;
import ee.qrental.job.domain.Job;
import org.springframework.stereotype.Component;

@Component
public class JobMapper
        implements DomainMapper<Job, JobJpaEntity> {

    @Override
    public Job mapToDomain(final JobJpaEntity jpaEntity) {
        return null;
    }

    @Override
    public JobJpaEntity mapToEntity(final Job domain) {
        return null;
    }
}
