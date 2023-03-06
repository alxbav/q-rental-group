package ee.qrental.job.application.service;

import ee.qrental.job.application.port.in.mapper.JobAddRequestMapper;
import ee.qrental.job.application.port.in.mapper.JobUpdateRequestMapper;
import ee.qrental.job.application.port.in.request.JobAddRequest;
import ee.qrental.job.application.port.in.request.JobDeleteRequest;
import ee.qrental.job.application.port.in.request.JobUpdateRequest;
import ee.qrental.job.application.port.in.usecase.JobAddUseCase;
import ee.qrental.job.application.port.in.usecase.JobDeleteUseCase;
import ee.qrental.job.application.port.in.usecase.JobUpdateUseCase;
import ee.qrental.job.application.port.out.JobAddPort;
import ee.qrental.job.application.port.out.JobDeletePort;
import ee.qrental.job.application.port.out.JobLoadPort;
import ee.qrental.job.application.port.out.JobUpdatePort;
import ee.qrental.job.application.validator.JobBusinessRuleValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class JobUseCaseService
        implements JobAddUseCase,
        JobUpdateUseCase,
        JobDeleteUseCase {

    private final JobAddPort addPort;
    private final JobUpdatePort updatePort;
    private final JobLoadPort loadPort;
    private final JobDeletePort deletePort;
    private final JobAddRequestMapper addRequestMapper;
    private final JobUpdateRequestMapper updateRequestMapper;
    private final JobBusinessRuleValidator businessRuleValidator;

    @Override
    public void add(final JobAddRequest request) {
        final var domain = addRequestMapper.toDomain(request);
        final var violationsCollector = businessRuleValidator.validate(domain);
        if (violationsCollector.hasViolations()) {
            request.setViolations(violationsCollector.getViolations());
            return;
        }
        addPort.add(domain);
    }

    @Override
    public void update(final JobUpdateRequest request) {
        checkExistence(request.getId());
        updatePort.update(updateRequestMapper.toDomain(request));
    }

    private void checkExistence(final Long id) {
        if (loadPort.loadById(id) == null) {
            throw new RuntimeException("Update of Link failed. No Record with id = " + id);
        }
    }

    @Override
    public void delete(JobDeleteRequest request) {
        deletePort.delete(request.getId());
    }
}