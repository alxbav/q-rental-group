package ee.qrental.transaction.application.port.in.usecase.transaction;

import ee.qrental.common.core.api.application.usecase.AddUseCase;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionAddRequest;

public interface TransactionAddUseCase
        extends AddUseCase<TransactionAddRequest> {
}
