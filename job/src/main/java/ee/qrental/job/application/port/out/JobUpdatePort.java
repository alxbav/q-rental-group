package ee.qrental.job.application.port.out;

import ee.qrental.job.domain.Job;

public interface JobUpdatePort {
    Job update(final Job domain);
}