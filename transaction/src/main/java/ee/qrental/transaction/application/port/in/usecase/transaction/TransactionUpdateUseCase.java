package ee.qrental.transaction.application.port.in.usecase.transaction;

import ee.qrental.common.core.api.application.usecase.UpdateUseCase;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionUpdateRequest;

public interface TransactionUpdateUseCase
        extends UpdateUseCase<TransactionUpdateRequest> {
}
