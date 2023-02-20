package ee.qrental.transaction.application.service;

import ee.qrental.transaction.application.port.in.request.firm.FirmAddRequest;
import ee.qrental.transaction.application.port.in.request.firm.FirmDeleteRequest;
import ee.qrental.transaction.application.port.in.request.firm.FirmUpdateRequest;
import ee.qrental.transaction.application.port.in.usecase.firm.FirmAddUseCase;
import ee.qrental.transaction.application.port.in.usecase.firm.FirmDeleteUseCase;
import ee.qrental.transaction.application.port.in.usecase.firm.FirmUpdateUseCase;
import ee.qrental.transaction.application.port.out.*;
import ee.qrental.transaction.domain.Firm;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class FirmUseCaseService implements
        FirmAddUseCase,
        FirmUpdateUseCase,
        FirmDeleteUseCase {

    private final FirmAddPort firmAddPort;

    private final FirmUpdatePort firmUpdatePort;

    private final FirmLoadPort firmLoadPort;

    private final FirmDeletePort firmDeletePort;

    @Override
    public void add(final FirmAddRequest command) {
        final var firmDomain = new Firm(
                null,
                command.getName(),
                command.getIban(),
                command.getRegNumber(),
                command.getVatNumber(),
                command.getComment());
        firmAddPort.add(firmDomain);
    }

    @Override
    public void update(final FirmUpdateRequest command) {
        final Long firmId = command.getId();
        final Firm domain = firmLoadPort.loadById(firmId);
        if (domain == null) {
            throw new RuntimeException("Update of Firm failed. No Firm with id = " + firmId);
        }
        updateDomain(command, domain);
        firmUpdatePort.update(domain);
    }

    private void updateDomain(
            final FirmUpdateRequest request,
            final Firm toUpdate) {
        toUpdate.setName(request.getName());
        toUpdate.setIban(request.getIban());
        toUpdate.setRegNumber(request.getRegNumber());
        toUpdate.setVatNumber(request.getVatNumber());
        toUpdate.setComment(request.getComment());
    }

    @Override
    public void delete(FirmDeleteRequest deleteCommand) {
        firmDeletePort.delete(deleteCommand.getId());
    }

}
