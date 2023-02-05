package ee.qrental.link.application.port.out;

import ee.qrental.link.domain.Transaction;

public interface TransactionUpdatePort {
    Transaction updateTransaction(Transaction transaction);
}
