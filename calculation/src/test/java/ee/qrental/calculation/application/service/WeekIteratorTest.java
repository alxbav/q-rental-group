package ee.qrental.calculation.application.service;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test data based on the first week of January 2023
 * where
 * Mon, Tue, Wed, Thu, Fri, Sat, Sun,  |  Mon, Tue
 * 2    3    4    5    6    7    8    |   9   10
 */
class WeekIteratorTest {

    @Test
    public void testWeekIteratorWithOneFullWeek() {
        //given
        final var startPeriod = LocalDate.of(2023, Month.JANUARY, 2);
        final var endPeriod = LocalDate.of(2023, Month.JANUARY, 8);
        final var weekIterator = new QWeekIterator(startPeriod, endPeriod);

        //when
        final var hasNext1 = weekIterator.hasNext();
        final var week1 = weekIterator.next();
        final var hasNext2 = weekIterator.hasNext();

        //then
        assertTrue(hasNext1);
        assertFalse(hasNext2);
        assertEquals(LocalDate.of(2023, Month.JANUARY, 2), week1.start());
        assertEquals(LocalDate.of(2023, Month.JANUARY, 8), week1.end());
    }

    @Test
    public void testWeekIteratorWithOnePartialWeek1() {
        //given
        final var startPeriod = LocalDate.of(2023, Month.JANUARY, 2);
        final var endPeriod = LocalDate.of(2023, Month.JANUARY, 3);
        final var weekIterator = new QWeekIterator(startPeriod, endPeriod);

        //when
        final var hasNext1 = weekIterator.hasNext();
        final var week1 = weekIterator.next();
        final var hasNext2 = weekIterator.hasNext();

        //then
        assertTrue(hasNext1);
        assertFalse(hasNext2);
        assertEquals(LocalDate.of(2023, Month.JANUARY, 2), week1.start());
        assertEquals(LocalDate.of(2023, Month.JANUARY, 3), week1.end());
    }

    @Test
    public void testWeekIteratorWithOnePartialWeek2() {
        //given
        final var startPeriod = LocalDate.of(2023, Month.JANUARY, 4);
        final var endPeriod = LocalDate.of(2023, Month.JANUARY, 6);
        final var weekIterator = new QWeekIterator(startPeriod, endPeriod);

        //when
        final var hasNext1 = weekIterator.hasNext();
        final var week1 = weekIterator.next();
        final var hasNext2 = weekIterator.hasNext();

        //then
        assertTrue(hasNext1);
        assertFalse(hasNext2);
        assertEquals(LocalDate.of(2023, Month.JANUARY, 4), week1.start());
        assertEquals(LocalDate.of(2023, Month.JANUARY, 6), week1.end());
    }

    @Test
    public void testWeekIteratorWithOnePartialWeek3() {
        //given
        final var startPeriod = LocalDate.of(2023, Month.JANUARY, 7);
        final var endPeriod = LocalDate.of(2023, Month.JANUARY, 8);
        final var weekIterator = new QWeekIterator(startPeriod, endPeriod);

        //when
        final var hasNext1 = weekIterator.hasNext();
        final var week1 = weekIterator.next();
        final var hasNext2 = weekIterator.hasNext();

        //then
        assertTrue(hasNext1);
        assertFalse(hasNext2);
        assertEquals(LocalDate.of(2023, Month.JANUARY, 7), week1.start());
        assertEquals(LocalDate.of(2023, Month.JANUARY, 8), week1.end());
    }

    @Test
    public void testWeekIteratorWithTwoPartialWeeks1() {
        //given
        final var startPeriod = LocalDate.of(2023, Month.JANUARY, 6);
        final var endPeriod = LocalDate.of(2023, Month.JANUARY, 10);
        final var weekIterator = new QWeekIterator(startPeriod, endPeriod);

        //when
        final var hasNext1 = weekIterator.hasNext();
        final var week1 = weekIterator.next();
        final var hasNext2 = weekIterator.hasNext();
        final var week2 = weekIterator.next();
        final var hasNext3 = weekIterator.hasNext();

        //then
        assertTrue(hasNext1);
        assertTrue(hasNext2);
        assertFalse(hasNext3);
        assertEquals(LocalDate.of(2023, Month.JANUARY, 6), week1.start());
        assertEquals(LocalDate.of(2023, Month.JANUARY, 8), week1.end());
        assertEquals(LocalDate.of(2023, Month.JANUARY, 9), week2.start());
        assertEquals(LocalDate.of(2023, Month.JANUARY, 10), week2.end());
    }
}