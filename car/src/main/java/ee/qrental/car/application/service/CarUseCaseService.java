package ee.qrental.car.application.service;

import ee.qrental.car.application.port.in.mapper.CarAddRequestMapper;
import ee.qrental.car.application.port.in.mapper.CarUpdateRequestMapper;
import ee.qrental.car.application.port.in.request.CarAddRequest;
import ee.qrental.car.application.port.in.request.CarDeleteRequest;
import ee.qrental.car.application.port.in.request.CarUpdateRequest;
import ee.qrental.car.application.port.in.usecase.CarAddUseCase;
import ee.qrental.car.application.port.in.usecase.CarDeleteUseCase;
import ee.qrental.car.application.port.in.usecase.CarUpdateUseCase;
import ee.qrental.car.application.port.out.CarAddPort;
import ee.qrental.car.application.port.out.CarDeletePort;
import ee.qrental.car.application.port.out.CarLoadPort;
import ee.qrental.car.application.port.out.CarUpdatePort;
import ee.qrental.car.application.port.validator.CarBusinessRuleValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service

@AllArgsConstructor
class CarUseCaseService
        implements CarAddUseCase,
        CarUpdateUseCase,
        CarDeleteUseCase {

    private final CarAddPort addPort;
    private final CarUpdatePort updatePort;
    private final CarLoadPort loadPort;
    private final CarDeletePort deletePort;
    private final CarAddRequestMapper addRequestMapper;
    private final CarUpdateRequestMapper updateRequestMapper;
    private final CarBusinessRuleValidator businessRuleValidator;

    @Override
    public Long add(final CarAddRequest request) {
        final var domain = addRequestMapper.toDomain(request);
        final var violationsCollector = businessRuleValidator.validate(domain);
        if (violationsCollector.hasViolations()) {
            request.setViolations(violationsCollector.getViolations());

            return null;
        }

        return addPort.add(addRequestMapper.toDomain(request)).getId();
    }

    @Override
    public void update(final CarUpdateRequest request) {
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
    public void delete(CarDeleteRequest request) {
        deletePort.delete(request.getId());
    }

    private void checkExistence(final Long id) {
        if (loadPort.loadById(id) == null) {
            throw new RuntimeException("Update of CallSign failed. No Record with id = " + id);
        }
    }
}
