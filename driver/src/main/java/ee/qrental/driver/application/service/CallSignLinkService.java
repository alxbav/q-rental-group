package ee.qrental.driver.application.service;

import ee.qrental.driver.application.port.in.command.CallSignLinkAddCommand;
import ee.qrental.driver.application.port.in.command.CallSignLinkDeleteCommand;
import ee.qrental.driver.application.port.in.command.CallSignLinkUpdateCommand;
import ee.qrental.driver.application.port.in.usecase.CallSignLinkAddUseCase;
import ee.qrental.driver.application.port.in.usecase.CallSignLinkUpdateUseCase;
import ee.qrental.driver.application.port.in.usecase.CallSignLinkDeleteUseCase;
import ee.qrental.driver.application.port.out.*;
import ee.qrental.driver.domain.CallSignLink;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class CallSignLinkService implements
        CallSignLinkAddUseCase,
        CallSignLinkUpdateUseCase,
        CallSignLinkDeleteUseCase {

    private final CallSignLinkAddPort callSignLinkAddPort;

    private final CallSignLinkUpdatePort callSignLinkUpdatePort;
    private final CallSignLinkLoadPort callSignLinkLoadPort;
    private final CallSignLinkDeletePort callSignLinkDeletePort;


    @Override
    public void add(final CallSignLinkAddCommand command) {
        final var domain = new CallSignLink(
                null,
                command.getCallSign(),
                command.getDriverId(),
                command.getDateStart(),
                command.getDateEnd(),
                command.getComment());
        callSignLinkAddPort.addCallSignLink(domain);
    }

    @Override
    public void update(final CallSignLinkUpdateCommand command) {
        final Long callSignLinkId = command.getId();
        final CallSignLink domain = callSignLinkLoadPort.loadCallSignLinkById(callSignLinkId);
        if (domain == null) {
            throw new RuntimeException("Update of Call Sign Link failed. No Call Sign Link with id = " + callSignLinkId);
        }
        updateDomain(command, domain);
        callSignLinkUpdatePort.updateCallSignLink(domain);
    }

    private void updateDomain(
            final CallSignLinkUpdateCommand command,
            final CallSignLink toUpdate) {
        toUpdate.setDriverId(command.getDriverId());
        toUpdate.setCallSign(command.getCallSign());
        toUpdate.setDateStart(command.getDateStart());
        toUpdate.setDateEnd(command.getDateEnd());
        toUpdate.setComment(command.getComment());
    }

    @Override
    public void delete(CallSignLinkDeleteCommand deleteCommand) {

        callSignLinkDeletePort.deleteCallSignLink(deleteCommand.getId());
    }
}
