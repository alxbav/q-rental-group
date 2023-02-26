package ee.qrental.transaction.application.service.strategy;

import ee.qrental.transaction.application.port.in.request.transaction.TransactionFilterRequest;
import ee.qrental.transaction.application.port.in.utils.Week;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.Month.JUNE;
import static java.time.temporal.IsoFields.WEEK_OF_WEEK_BASED_YEAR;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

@Component
@AllArgsConstructor
public class TransactionLoadStrategyByYearAndWeek implements TransactionLoadStrategy {

    private final TransactionLoadPort transactionLoadPort;

    @Override
    public boolean canApply(TransactionFilterRequest request) {
        return request.getDriverId() == null && request.getWeek() != Week.ALL;
    }

    @Override
    public List<Transaction> load(TransactionFilterRequest request) {
        final var year = request.getYear();
        final var weekNumber = request.getWeek().getNumber();
        final var startDate = getDayByYearAndWeekNumberAndDayOfWeek(year, weekNumber, MONDAY);
        final var endDate = getDayByYearAndWeekNumberAndDayOfWeek(year, weekNumber, SUNDAY);

        return transactionLoadPort.loadAllBetweenDays(startDate, endDate);
    }

    private LocalDate getDayByYearAndWeekNumberAndDayOfWeek(
            final Integer year,
            final Integer weekNumber,
            final DayOfWeek dayOfWeek) {
        return LocalDate.of(year, JUNE, 1)
                .with(previousOrSame(dayOfWeek))
                .with(WEEK_OF_WEEK_BASED_YEAR, weekNumber);
    }
}
