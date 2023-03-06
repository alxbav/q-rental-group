package ee.qrental.transaction.application.port.out;

import ee.qrental.common.core.api.application.port.LoadPort;
import ee.qrental.transaction.domain.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionLoadPort
        extends LoadPort<Transaction> {

    List<Transaction> loadAllByDriverId(final Long driverId);

    List<Transaction> loadAllBetweenDays(
            final LocalDate dateStart, final LocalDate dateEnd);

    List<Transaction> loadAllByDriverIdAndBetweenDays(
            final Long driverId, final LocalDate dateStart, final LocalDate dateEnd);
}
