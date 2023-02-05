package ee.qrental.link.application.port.out;

import ee.qrental.link.domain.Transaction;

import java.util.List;

public interface TransactionLoadPort {
    List<Transaction> loadAllTransactions();

    Transaction loadTransactionById(Long id);
}
