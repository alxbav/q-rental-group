package ee.qrental.link.application.service;

import ee.qrental.link.application.port.in.request.LinkAddCommand;
import ee.qrental.link.application.port.in.usecase.LinkAddUseCase;
import ee.qrental.link.application.port.out.LinkDeletePort;
import ee.qrental.link.application.port.in.request.LinkUpdateCommand;
import ee.qrental.link.application.port.in.usecase.LinkDeleteUseCase;
import ee.qrental.link.application.port.in.usecase.LinkUpdateUseCase;
import ee.qrental.link.application.port.out.LinkAddPort;
import ee.qrental.link.application.port.out.LinkLoadPort;
import ee.qrental.link.application.port.out.LinkUpdatePort;
import ee.qrental.link.domain.Link;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class LinkService implements
        LinkAddUseCase,
        LinkUpdateUseCase,
        LinkDeleteUseCase {

    private final LinkAddPort linkAddPort;

    private final LinkUpdatePort linkUpdatePort;

    private final LinkLoadPort linkLoadPort;

    private final LinkDeletePort linkDeletePort;

    @Override
    public void add(final LinkAddCommand command) {
        final var linkDomain = new Link(
                null,
                command.getCarId(),
                command.getDriverId(),
                command.getLinkType(),
                command.getDateStart(),
                command.getDateEnd(),
                command.getComment());
        linkAddPort.addLink(linkDomain);
    }

    @Override
    public void update(final LinkUpdateCommand command) {
        final Long linkId = command.getId();
        final Link domain = linkLoadPort.loadLinkById(linkId);
        if (domain == null) {
            throw new RuntimeException("Update of Link failed. No Link Type with id = " + linkId);
        }
        updateDomain(command, domain);
        linkUpdatePort.updateLink(domain);
    }

    private void updateDomain(
            final LinkUpdateCommand command,
            final Link toUpdate) {
        toUpdate.setCarId(command.getCarId());
        toUpdate.setDriverId(command.getDriverId());
        toUpdate.setLinkType(command.getLinkType());
        toUpdate.setDateStart(command.getDateStart());
        toUpdate.setDateEnd(command.getDateEnd());
        toUpdate.setComment(command.getComment());
    }

    @Override
    public void delete(Long linkId) {
        linkDeletePort.deleteLink(linkId);
    }
}
