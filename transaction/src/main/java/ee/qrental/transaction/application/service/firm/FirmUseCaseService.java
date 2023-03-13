package ee.qrental.transaction.application.service.firm;

import ee.qrental.transaction.application.port.in.mapper.firm.FirmAddRequestMapper;
import ee.qrental.transaction.application.port.in.mapper.firm.FirmUpdateRequestMapper;
import ee.qrental.transaction.application.port.in.request.firm.FirmAddRequest;
import ee.qrental.transaction.application.port.in.request.firm.FirmDeleteRequest;
import ee.qrental.transaction.application.port.in.request.firm.FirmUpdateRequest;
import ee.qrental.transaction.application.port.in.usecase.firm.FirmAddUseCase;
import ee.qrental.transaction.application.port.in.usecase.firm.FirmDeleteUseCase;
import ee.qrental.transaction.application.port.in.usecase.firm.FirmUpdateUseCase;
import ee.qrental.transaction.application.port.out.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FirmUseCaseService
        implements FirmAddUseCase,
        FirmUpdateUseCase,
        FirmDeleteUseCase {

    private final FirmAddPort addPort;
    private final FirmUpdatePort updatePort;
    private final FirmDeletePort deletePort;

    private final FirmLoadPort loadPort;

    private final FirmAddRequestMapper addRequestMapper;
    private final FirmUpdateRequestMapper updateRequestMapper;

    @Override
    public void add(final FirmAddRequest request) {
        addPort.add(addRequestMapper.toDomain(request));
    }

    @Override
    public void update(final FirmUpdateRequest request) {
        checkExistence(request.getId());
        updatePort.update(updateRequestMapper.toDomain(request));
    }

    @Override
    public void delete(final FirmDeleteRequest request) {
        deletePort.delete(request.getId());
    }

    private void checkExistence(final Long id) {
        if (loadPort.loadById(id) == null) {
            throw new RuntimeException("Update of Transaction Type failed. No Record with id = " + id);
        }
    }
}
