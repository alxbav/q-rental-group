package ee.qrental.callsignlink.application.service;


import ee.qrental.callsignlink.application.port.in.mapper.callSign.CallSignAddRequestMapper;
import ee.qrental.callsignlink.application.port.in.mapper.callSign.CallSignUpdateRequestMapper;
import ee.qrental.callsignlink.application.port.in.request.callsign.CallSignAddRequest;
import ee.qrental.callsignlink.application.port.in.request.callsign.CallSignDeleteRequest;
import ee.qrental.callsignlink.application.port.in.request.callsign.CallSignUpdateRequest;
import ee.qrental.callsignlink.application.port.in.usecase.callsign.CallSignAddUseCase;
import ee.qrental.callsignlink.application.port.in.usecase.callsign.CallSignDeleteUseCase;
import ee.qrental.callsignlink.application.port.in.usecase.callsign.CallSignUpdateUseCase;
import ee.qrental.callsignlink.application.port.out.callsign.CallSignAddPort;
import ee.qrental.callsignlink.application.port.out.callsign.CallSignDeletePort;
import ee.qrental.callsignlink.application.port.out.callsign.CallSignLoadPort;
import ee.qrental.callsignlink.application.port.out.callsign.CallSignUpdatePort;
import ee.qrental.callsignlink.application.validator.CallSignBusinessRuleValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class CallSignUseCaseService implements
        CallSignAddUseCase,
        CallSignUpdateUseCase,
        CallSignDeleteUseCase {

    private final CallSignAddPort addPort;
    private final CallSignUpdatePort updatePort;
    private final CallSignDeletePort deletePort;

    private final CallSignLoadPort loadPort;
    private final CallSignAddRequestMapper addRequestMapper;
    private final CallSignUpdateRequestMapper updateRequestMapper;
    private final CallSignBusinessRuleValidator businessRuleValidator;

    @Override
    public void add(final CallSignAddRequest request) {
        final var domain = addRequestMapper.toDomain(request);
        final var violationsCollector = businessRuleValidator.validate(domain);
        if (violationsCollector.hasViolations()) {
            request.setViolations(violationsCollector.getViolations());
            return;
        }
        addPort.add(addRequestMapper.toDomain(request));
    }

    @Override
    public void update(final CallSignUpdateRequest request) {
        checkExistence(request.getId());
        final var domain = updateRequestMapper.toDomain(request);
        final var violationsCollector = businessRuleValidator.validate(domain);
        if (violationsCollector.hasViolations()) {
            request.setViolations(violationsCollector.getViolations());
            return;
        }
        updatePort.update(updateRequestMapper.toDomain(request));
    }

    @Override
    public void delete(final CallSignDeleteRequest request) {
        deletePort.delete(request.getId());
    }

    private void checkExistence(final Long id) {
        if (loadPort.loadById(id) == null) {
            throw new RuntimeException("Update of CallSign failed. No Record with id = " + id);
        }
    }
}
