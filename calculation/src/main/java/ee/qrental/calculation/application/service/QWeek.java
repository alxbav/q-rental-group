package ee.qrental.calculation.application.service;

import java.time.DayOfWeek;
import java.time.LocalDate;

public record QWeek(LocalDate start, LocalDate end) {
    public boolean isFull() {
        return start.getDayOfWeek() == DayOfWeek.MONDAY
                && end.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}