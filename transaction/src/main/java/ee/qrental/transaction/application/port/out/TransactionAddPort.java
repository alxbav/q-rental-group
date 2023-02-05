package ee.qrental.transaction.application.port.out;

import ee.qrental.transaction.domain.Transaction;

public interface TransactionAddPort {
    Transaction addTransaction(Transaction transaction);
}
