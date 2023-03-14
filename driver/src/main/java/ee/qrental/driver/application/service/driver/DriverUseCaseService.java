package ee.qrental.driver.application.service.driver;

import ee.qrental.driver.application.port.in.mapper.driver.DriverAddRequestMapper;
import ee.qrental.driver.application.port.in.mapper.driver.DriverUpdateRequestMapper;
import ee.qrental.driver.application.port.in.request.driver.DriverAddRequest;
import ee.qrental.driver.application.port.in.request.driver.DriverDeleteRequest;
import ee.qrental.driver.application.port.in.request.driver.DriverUpdateRequest;
import ee.qrental.driver.application.port.in.usecase.driver.DriverAddUseCase;
import ee.qrental.driver.application.port.in.usecase.driver.DriverDeleteUseCase;
import ee.qrental.driver.application.port.in.usecase.driver.DriverUpdateUseCase;
import ee.qrental.driver.application.port.out.DriverAddPort;
import ee.qrental.driver.application.port.out.DriverDeletePort;
import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.driver.application.port.out.DriverUpdatePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service

@AllArgsConstructor
public class DriverUseCaseService
        implements DriverAddUseCase,
        DriverUpdateUseCase,
        DriverDeleteUseCase {

    private final DriverAddPort addPort;
    private final DriverUpdatePort updatePort;
    private final DriverDeletePort deletePort;
    private final DriverLoadPort loadPort;
    private final DriverAddRequestMapper addRequestMapper;
    private final DriverUpdateRequestMapper updateRequestMapper;

    @Override
    public Long add(final DriverAddRequest request) {
        return addPort.add(addRequestMapper.toDomain(request)).getId();
    }

    @Override
    public void update(final DriverUpdateRequest request) {
        checkExistence(request.getId());
        updatePort.update(updateRequestMapper.toDomain(request));
    }

    @Override
    public void delete(final DriverDeleteRequest request) {
        deletePort.delete(request.getId());
    }

    private void checkExistence(final Long id) {
        if (loadPort.loadById(id) == null) {
            throw new RuntimeException("Update of Driver failed. No Record with id = " + id);
        }
    }
}
