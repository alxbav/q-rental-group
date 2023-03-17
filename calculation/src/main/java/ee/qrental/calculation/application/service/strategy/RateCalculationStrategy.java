package ee.qrental.calculation.application.service.strategy;

import ee.qrental.calculation.application.service.QWeek;

import java.math.BigDecimal;

public interface RateCalculationStrategy {
    boolean canApply(final QWeek week);

    BigDecimal calculate(final QWeek week);
}
