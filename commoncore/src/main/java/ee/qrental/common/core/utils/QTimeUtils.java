package ee.qrental.common.core.utils;

import lombok.experimental.UtilityClass;

import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.LocalDate.of;
import static java.time.Month.JUNE;
import static java.time.temporal.IsoFields.WEEK_OF_WEEK_BASED_YEAR;
import static java.time.temporal.TemporalAdjusters.*;
import static java.util.Locale.getDefault;

@UtilityClass
public class QTimeUtils {

    public static int getWeekNumber(final LocalDate date) {
        return date.get(
                WeekFields.of(getDefault()).weekOfWeekBasedYear());
    }

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

    public static LocalDate getLastSundayFromDate(
            @NotNull final LocalDate fromDate) {
        if (fromDate == null) {
            throw new RuntimeException(
                    "Impossible to calculate last Sunday, if fromDate is NULL.");
        }
        if (fromDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return fromDate;
        }
        final var currentYear = fromDate.getYear();
        final var currentWeekNumber = getWeekNumber(fromDate);
        final var actionWeekNumber = currentWeekNumber - 1;

        return getLastDayOfWeekInYear(currentYear, actionWeekNumber);
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
