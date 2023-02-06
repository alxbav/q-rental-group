package ee.qrental.transaction.application.port.out;

import ee.qrental.transaction.domain.TransactionType;

public interface TransactionTypeUpdatePort {
    TransactionType updateTransactionType(TransactionType transactionType);
}
