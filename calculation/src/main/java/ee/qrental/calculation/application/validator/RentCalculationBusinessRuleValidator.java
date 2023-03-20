package ee.qrental.calculation.application.validator;


import ee.qrental.calculation.application.port.out.RentCalculationLoadPort;
import ee.qrental.calculation.domain.RentCalculation;
import ee.qrental.common.core.api.application.validation.QValidator;
import ee.qrental.common.core.api.application.validation.ViolationsCollector;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static ee.qrental.common.core.utils.QTimeUtils.getLastSundayFromDate;
import static java.time.temporal.ChronoUnit.DAYS;

@Component

@AllArgsConstructor
public class RentCalculationBusinessRuleValidator
        implements QValidator<RentCalculation> {

    private final RentCalculationLoadPort loadPort;

    @Override
    public ViolationsCollector validate(final RentCalculation domain) {
        final var violationsCollector = new ViolationsCollector();


        return violationsCollector;
    }

}
