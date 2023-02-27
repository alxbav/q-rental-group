package ee.qrental.transaction.application.service.strategy;

import lombok.experimental.UtilityClass;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.LocalDate.of;
import static java.time.Month.JUNE;
import static java.time.temporal.IsoFields.WEEK_OF_WEEK_BASED_YEAR;
import static java.time.temporal.TemporalAdjusters.*;

@UtilityClass
public class TransactionLoadUtils {
    public static LocalDate getFirstDayOfYear(final Integer year) {
        return of(year, 1, 1).with(firstDayOfYear());
    }

    public static LocalDate getLastDayOfYear(final Integer year) {
        return of(year, 1, 1).with(lastDayOfYear());
    }

    public static LocalDate getFirstDayOfWeekInYear(final Integer year,
                                                    final Integer weekNumber) {
        return getDayByYearAndWeekNumberAndDayOfWeek(year, weekNumber, MONDAY);
    }

    public static LocalDate getLastDayOfWeekInYear(final Integer year,
                                                   final Integer weekNumber) {
        return getDayByYearAndWeekNumberAndDayOfWeek(year, weekNumber, SUNDAY);
    }

    private static LocalDate getDayByYearAndWeekNumberAndDayOfWeek(
            final Integer year,
            final Integer weekNumber,
            final DayOfWeek dayOfWeek) {
        return LocalDate.of(year, JUNE, 1)
                .with(previousOrSame(dayOfWeek))
                .with(WEEK_OF_WEEK_BASED_YEAR, weekNumber);
    }
}
