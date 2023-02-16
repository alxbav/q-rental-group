package ee.qrental.transaction.application.service;

import ee.qrental.transaction.application.port.in.command.*;
import ee.qrental.transaction.application.port.in.usecase.*;
import ee.qrental.transaction.application.port.out.*;
import ee.qrental.transaction.domain.Constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class ConstantService implements
        ConstantAddUseCase,
        ConstantUpdateUseCase,
        ConstantDeleteUseCase {

    private final ConstantAddPort constantAddPort;

    private final ConstantUpdatePort constantUpdatePort;

    private final ConstantLoadPort constantLoadPort;

    private final ConstantDeletePort constantDeletePort;

    @Override
    public void add(final ConstantAddCommand command) {
        final var constantDomain = new Constant(
                null,
                command.getName(),
                command.getValue(),
                command.getDescription(),
                command.getNegative());
        constantAddPort.addConstant(constantDomain);
    }

    @Override
    public void update(final ConstantUpdateCommand command) {
        final Long constantId = command.getId();
        final Constant domain = constantLoadPort.loadConstantById(constantId);
        if (domain == null) {
            throw new RuntimeException("Update of Constant failed. No Constant with id = " + constantId);
        }
        updateDomain(command, domain);
        constantUpdatePort.updateConstant(domain);
    }

    private void updateDomain(
            final ConstantUpdateCommand command,
            final Constant toUpdate) {
        toUpdate.setName(command.getName());
        toUpdate.setValue(command.getValue());
        toUpdate.setDescription(command.getDescription());
        toUpdate.setNegative(command.getNegative());
    }

    @Override
    public void delete(ConstantDeleteCommand deleteCommand) {
        constantDeletePort.deleteConstant(deleteCommand.getId());
    }

}
