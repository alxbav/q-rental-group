package ee.qrental.transaction.application.service.transaction.strategy;

import ee.qrental.common.core.utils.QTimeUtils;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionFilterRequest;
import ee.qrental.transaction.application.port.in.utils.Week;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

@AllArgsConstructor
public class TransactionLoadStrategyByDriverAndYearAndWeek
        implements TransactionLoadStrategy {

    private final TransactionLoadPort transactionLoadPort;

    @Override
    public boolean canApply(TransactionFilterRequest request) {
        return request.getDriverId() != null && request.getWeek() != Week.ALL;
    }

    @Override
    public List<Transaction> load(TransactionFilterRequest request) {
        final var year = request.getYear();
        final var weekNumber = request.getWeek().getNumber();

        return transactionLoadPort.loadAllByDriverIdAndBetweenDays(
                request.getDriverId(),
                QTimeUtils.getFirstDayOfWeekInYear(year, weekNumber),
                QTimeUtils.getLastDayOfWeekInYear(year, weekNumber));
    }
}
