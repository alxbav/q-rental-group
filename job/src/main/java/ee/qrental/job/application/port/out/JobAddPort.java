package ee.qrental.job.application.port.out;


import ee.qrental.job.domain.Job;

public interface JobAddPort {
    Job addLink(final Job domain);
}
