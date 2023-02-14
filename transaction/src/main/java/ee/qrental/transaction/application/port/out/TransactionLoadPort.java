package ee.qrental.transaction.application.port.out;

import ee.qrental.transaction.domain.Transaction;

import java.util.List;
import java.util.Set;

public interface TransactionLoadPort {
    List<Transaction> loadAllTransactions();

    Transaction loadTransactionById(Long id);
    Set<Transaction> loadTransactionByDriverId(Long driverId);
}
