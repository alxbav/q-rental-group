package ee.qrental.transaction.application.port.in.usecase.transaction;

import ee.qrental.common.core.api.application.usecase.DeleteUseCase;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionDeleteRequest;

public interface TransactionDeleteUseCase
        extends DeleteUseCase<TransactionDeleteRequest> {
}

