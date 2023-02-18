package ee.qrental.transaction.application.port.in.usecase.transaction;

import ee.qrental.common.core.api.usecase.UpdateUseCase;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionUpdateRequest;

public interface TransactionUpdateUseCase
        extends UpdateUseCase<TransactionUpdateRequest> {
}
