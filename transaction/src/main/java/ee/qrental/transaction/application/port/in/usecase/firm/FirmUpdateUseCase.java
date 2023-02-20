package ee.qrental.transaction.application.port.in.usecase.firm;

import ee.qrental.transaction.application.port.in.request.firm.FirmUpdateRequest;

public interface FirmUpdateUseCase {
    void update(FirmUpdateRequest firm);
}
