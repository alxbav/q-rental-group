package ee.qrental.transaction.application.port.in.usecase.firm;

import ee.qrental.transaction.application.port.in.request.firm.FirmDeleteRequest;

public interface FirmDeleteUseCase {
    void delete(FirmDeleteRequest deleteCommand);
}

