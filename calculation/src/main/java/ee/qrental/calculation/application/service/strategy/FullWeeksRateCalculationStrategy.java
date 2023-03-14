package ee.qrental.calculation.application.service.strategy;

import ee.qrental.calculation.application.service.QWeek;
import ee.qrental.transaction.application.port.out.ConstantLoadPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component

@AllArgsConstructor
public class FullWeeksRateCalculationStrategy
        implements RateCalculationStrategy {

    private static final String WEEKLY_RENT_FEE = "weekly_rent_fee";

    private final ConstantLoadPort constantLoadPort;

    @Override
    public boolean canApply(final QWeek week) {
        return week.isFull();
    }

    @Override
    public Long calculate(final QWeek week) {
        final var rate = constantLoadPort
                .loadConstantByName(WEEKLY_RENT_FEE)
                .getValue();
        final Double totalRate = rate * 100;

        return totalRate.longValue();
    }
}
