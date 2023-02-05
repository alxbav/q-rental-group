package ee.qrental.transaction.application.port.out;

import ee.qrental.transaction.domain.Transaction;

public interface TransactionUpdatePort {
    Transaction updateTransaction(Transaction transaction);
}
