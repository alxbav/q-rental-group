package ee.qrental.transaction.application.port.in.usecase.firm;

import ee.qrental.transaction.application.port.in.request.firm.FirmAddRequest;

public interface FirmAddUseCase {
    void add(FirmAddRequest firm);
}
