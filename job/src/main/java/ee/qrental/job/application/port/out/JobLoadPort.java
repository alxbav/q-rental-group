package ee.qrental.job.application.port.out;

import ee.qrental.job.domain.Job;

import java.util.List;

public interface JobLoadPort {
    List<Job> loadAll();

    Job loadById(final Long id);
}