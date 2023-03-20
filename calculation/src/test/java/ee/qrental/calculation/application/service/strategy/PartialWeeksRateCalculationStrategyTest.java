package ee.qrental.calculation.application.service.strategy;

import ee.qrental.calculation.application.service.QWeek;
import ee.qrental.transaction.application.port.out.ConstantLoadPort;
import ee.qrental.transaction.domain.Constant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Test data based on the first week of January 2023 where:
 * Mon, Tue, Wed, Thu, Fri, Sat, Sun
 * 2    3    4    5    6    7    8
 */
class PartialWeeksRateCalculationStrategyTest {

    private RateCalculationStrategy instanceUnderTest;
    private ConstantLoadPort constantLoadPort;

    @BeforeEach
    void init() {
        constantLoadPort = mock(ConstantLoadPort.class);
        instanceUnderTest = new PartialWeekRateCalculationStrategy(constantLoadPort);
    }

    @Test
    public void testPartialWeekCanApply() {
        //given
        final var week = new QWeek(
                LocalDate.of(2023, Month.JANUARY, 4),
                LocalDate.of(2023, Month.JANUARY, 8));

        //when
        final var result = instanceUnderTest.canApply(week);

        //then
        assertTrue(result);
    }

    @Test
    public void testPartialWeekCanNotApply() {
        //given
        final var week = new QWeek(
                LocalDate.of(2023, Month.JANUARY, 2),
                LocalDate.of(2023, Month.JANUARY, 8));

        //when
        final var result = instanceUnderTest.canApply(week);

        //then
        assertFalse(result);
    }

    @Test
    public void testPartialWeekCalculation() {
        //given
        when(constantLoadPort.loadConstantByName("daily_rent_fee"))
                .thenReturn(Constant.builder().value(2.0d).build());
        final var week = new QWeek(
                LocalDate.of(2023, Month.JANUARY, 4),
                LocalDate.of(2023, Month.JANUARY, 8));

        //when
        final var result = instanceUnderTest.calculate(week);

        //then
        assertEquals(BigDecimal.valueOf(1000d), result);
    }
}