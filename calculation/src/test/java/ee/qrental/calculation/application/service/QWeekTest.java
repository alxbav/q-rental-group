package ee.qrental.calculation.application.service;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test data based on the first week of January 2023 where:
 * Mon, Tue, Wed, Thu, Fri, Sat, Sun
 * 2    3    4    5    6    7    8
 */
public class QWeekTest {

    @Test
    public void testFullWeek() {
        //given
        final var start = LocalDate.of(2023, Month.JANUARY, 2);
        final var end = LocalDate.of(2023, Month.JANUARY, 8);
        final var week = new QWeek(start, end);

        //when
        final var isFull = week.isFull();

        //then
        assertTrue(isFull);
    }

    @Test
    public void testPartialWeek1() {
        //given
        final var start = LocalDate.of(2023, Month.JANUARY, 2);
        final var end = LocalDate.of(2023, Month.JANUARY, 3);
        final var week = new QWeek(start, end);

        //when
        final var isFull = week.isFull();

        //then
        assertFalse(isFull);
    }

    @Test
    public void testPartialWeek2() {
        //given
        final var start = LocalDate.of(2023, Month.JANUARY, 4);
        final var end = LocalDate.of(2023, Month.JANUARY, 5);
        final var week = new QWeek(start, end);

        //when
        final var isFull = week.isFull();

        //then
        assertFalse(isFull);
    }

    @Test
    public void testPartialWeek3() {
        //given
        final var start = LocalDate.of(2023, Month.JANUARY, 6);
        final var end = LocalDate.of(2023, Month.JANUARY, 8);
        final var week = new QWeek(start, end);

        //when
        final var isFull = week.isFull();

        //then
        assertFalse(isFull);
    }


}
