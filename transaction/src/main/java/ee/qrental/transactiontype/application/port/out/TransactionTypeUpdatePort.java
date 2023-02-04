package ee.qrental.transactiontype.application.port.out;

import ee.qrental.transactiontype.domain.TransactionType;

public interface TransactionTypeUpdatePort {
    TransactionType updateTransactionType(TransactionType transactionType);
}
