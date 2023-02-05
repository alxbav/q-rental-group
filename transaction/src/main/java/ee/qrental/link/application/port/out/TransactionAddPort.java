package ee.qrental.link.application.port.out;

import ee.qrental.link.domain.Transaction;

public interface TransactionAddPort {
    Transaction addTransaction(Transaction transaction);
}
