package ee.qrental.callsignlink.application.service;


import ee.qrental.callsignlink.application.port.in.mapper.callSignLink.CallSignLinkAddRequestMapper;
import ee.qrental.callsignlink.application.port.in.mapper.callSignLink.CallSignLinkUpdateRequestMapper;
import ee.qrental.callsignlink.application.port.in.request.callsignlink.CallSignLinkAddRequest;
import ee.qrental.callsignlink.application.port.in.request.callsignlink.CallSignLinkDeleteRequest;
import ee.qrental.callsignlink.application.port.in.request.callsignlink.CallSignLinkUpdateRequest;
import ee.qrental.callsignlink.application.port.in.usecase.callsignlink.CallSignLinkAddUseCase;
import ee.qrental.callsignlink.application.port.in.usecase.callsignlink.CallSignLinkDeleteUseCase;
import ee.qrental.callsignlink.application.port.in.usecase.callsignlink.CallSignLinkUpdateUseCase;
import ee.qrental.callsignlink.application.port.out.callsignlink.CallSignLinkAddPort;
import ee.qrental.callsignlink.application.port.out.callsignlink.CallSignLinkDeletePort;
import ee.qrental.callsignlink.application.port.out.callsignlink.CallSignLinkLoadPort;
import ee.qrental.callsignlink.application.port.out.callsignlink.CallSignLinkUpdatePort;
import ee.qrental.callsignlink.application.validator.CallSignLinkBusinessRuleValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class CallSignLinkUseCaseService implements
        CallSignLinkAddUseCase,
        CallSignLinkUpdateUseCase,
        CallSignLinkDeleteUseCase {

    private final CallSignLinkAddPort addPort;
    private final CallSignLinkUpdatePort updatePort;
    private final CallSignLinkDeletePort deletePort;
    private final CallSignLinkLoadPort loadPort;
    private final CallSignLinkAddRequestMapper addRequestMapper;
    private final CallSignLinkUpdateRequestMapper updateRequestMapper;
    private final CallSignLinkBusinessRuleValidator businessRuleValidator;

    @Override
    public Long add(final CallSignLinkAddRequest request) {
        final var domain = addRequestMapper.toDomain(request);
        final var violationsCollector = businessRuleValidator.validate(domain);
        if (violationsCollector.hasViolations()) {
            request.setViolations(violationsCollector.getViolations());
            return null;
        }

        return addPort.add(addRequestMapper.toDomain(request)).getId();
    }

    @Override
    public void update(final CallSignLinkUpdateRequest request) {
        checkExistence(request.getId());
        final var domain = updateRequestMapper.toDomain(request);
        final var violationsCollector = businessRuleValidator.validate(domain);
        if (violationsCollector.hasViolations()) {
            request.setViolations(violationsCollector.getViolations());

            return;
        }
        updatePort.update(updateRequestMapper.toDomain(request));
    }

    private void checkExistence(final Long id) {
        if (loadPort.loadById(id) == null) {
            throw new RuntimeException("Update of CallSign Link failed. No Record with id = " + id);
        }
    }

    @Override
    public void delete(final CallSignLinkDeleteRequest request) {
        deletePort.delete(request.getId());
    }
}