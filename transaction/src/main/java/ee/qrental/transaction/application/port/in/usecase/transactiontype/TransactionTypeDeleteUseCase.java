package ee.qrental.transaction.application.port.in.usecase.transactiontype;

import ee.qrental.common.core.api.application.usecase.DeleteUseCase;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionTypeDeleteRequest;

public interface TransactionTypeDeleteUseCase
        extends DeleteUseCase<TransactionTypeDeleteRequest> {
}

