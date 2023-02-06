package ee.qrental.transaction.application.port.out;

import ee.qrental.transaction.domain.TransactionType;

public interface TransactionTypeAddPort {
    TransactionType addTransactionType(TransactionType transactionType);
}
