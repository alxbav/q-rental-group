package ee.qrental.calculation.application.service.strategy;

import ee.qrental.calculation.application.service.QWeek;

public interface RateCalculationStrategy {
    boolean canApply(final QWeek week);

    Long calculate(final QWeek week);
}
