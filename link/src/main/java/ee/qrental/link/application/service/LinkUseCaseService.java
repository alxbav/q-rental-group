package ee.qrental.link.application.service;

import ee.qrental.link.application.port.in.mapper.LinkAddRequestMapper;
import ee.qrental.link.application.port.in.mapper.LinkUpdateRequestMapper;
import ee.qrental.link.application.port.in.request.LinkAddRequest;
import ee.qrental.link.application.port.in.request.LinkDeleteRequest;
import ee.qrental.link.application.port.in.request.LinkUpdateRequest;
import ee.qrental.link.application.port.in.usecase.LinkAddUseCase;
import ee.qrental.link.application.port.in.usecase.LinkDeleteUseCase;
import ee.qrental.link.application.port.in.usecase.LinkUpdateUseCase;
import ee.qrental.link.application.port.out.LinkAddPort;
import ee.qrental.link.application.port.out.LinkDeletePort;
import ee.qrental.link.application.port.out.LinkLoadPort;
import ee.qrental.link.application.port.out.LinkUpdatePort;
import ee.qrental.link.application.validator.LinkBusinessRuleValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class LinkUseCaseService implements
        LinkAddUseCase,
        LinkUpdateUseCase,
        LinkDeleteUseCase {

    private final LinkAddPort linkAddPort;
    private final LinkUpdatePort linkUpdatePort;
    private final LinkLoadPort linkLoadPort;
    private final LinkDeletePort linkDeletePort;
    private final LinkAddRequestMapper addRequestMapper;
    private final LinkUpdateRequestMapper updateRequestMapper;
    private final LinkBusinessRuleValidator businessRuleValidator;

    @Override
    public void add(final LinkAddRequest request) {
        final var domain = addRequestMapper.toDomain(request);
        final var violationsCollector = businessRuleValidator.validate(domain);
        if (violationsCollector.hasViolations()) {
            request.setViolations(violationsCollector.getViolations());
            return;
        }
        linkAddPort.addLink(domain);
    }

    @Override
    public void update(final LinkUpdateRequest request) {
        checkExistence(request.getId());
        linkUpdatePort.updateLink(updateRequestMapper.toDomain(request));
    }

    private void checkExistence(final Long id) {
        if (linkLoadPort.loadById(id) == null) {
            throw new RuntimeException("Update of Link failed. No Link with id = " + id);
        }
    }

    @Override
    public void delete(LinkDeleteRequest request) {
        linkDeletePort.deleteLink(request.getId());
    }


}
