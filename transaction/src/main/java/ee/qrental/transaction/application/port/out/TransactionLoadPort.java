package ee.qrental.transaction.application.port.out;

import ee.qrental.transaction.domain.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionLoadPort {
    Transaction loadById(final Long id);
    List<Transaction> loadAll();

    List<Transaction> loadAllByDriverId(final Long driverId);
    List<Transaction> loadAllBetweenDays(
            final LocalDate dateStart, final LocalDate dateEnd);

    List<Transaction> loadAllByDriverIdAndBetweenDays(
            final Long driverId, final LocalDate dateStart, final LocalDate dateEnd);
}
