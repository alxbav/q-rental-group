package ee.qrental.calculation.application.service.strategy;

import ee.qrental.calculation.application.service.QWeek;
import ee.qrental.transaction.application.port.out.ConstantLoadPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Period;

@Component

@AllArgsConstructor
public class PartialWeekRateCalculationStrategy implements RateCalculationStrategy {

    private static final String DAILY_RENT_FEE = "daily_rent_fee";
    private final ConstantLoadPort constantLoadPort;

    @Override
    public boolean canApply(final QWeek week) {
        return !week.isFull();
    }

    @Override
    public BigDecimal calculate(final QWeek week) {
        final var rate = constantLoadPort.loadConstantByName(DAILY_RENT_FEE).getValue();
        final var days = Period.between(week.start(), week.end()).getDays();

        return BigDecimal.valueOf((days + 1) * rate * 100);
    }
}