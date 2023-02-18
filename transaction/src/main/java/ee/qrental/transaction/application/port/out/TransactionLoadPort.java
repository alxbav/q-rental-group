package ee.qrental.transaction.application.port.out;

import ee.qrental.transaction.domain.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionLoadPort {
    Transaction loadById(Long id);
    List<Transaction> loadAll();

    List<Transaction> loadAllByDriverId(Long driverId);
    List<Transaction> loadAllBetweenDays(
            LocalDate dateStart, LocalDate dateEnd);
}
