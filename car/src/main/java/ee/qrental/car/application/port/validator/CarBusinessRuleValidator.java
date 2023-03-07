package ee.qrental.car.application.port.validator;

import ee.qrental.car.application.port.out.CarLoadPort;
import ee.qrental.car.domain.Car;
import ee.qrental.common.core.api.application.validation.QValidator;
import ee.qrental.common.core.api.application.validation.ViolationsCollector;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
@AllArgsConstructor
public class CarBusinessRuleValidator implements QValidator<Car> {

    private final CarLoadPort carLoadPort;

    @Override
    public ViolationsCollector validate(final Car domain) {
        final var violationsCollector = new ViolationsCollector();
        checkUniqueness(domain, violationsCollector);

        return violationsCollector;
    }

    private void checkUniqueness(
            final Car domain,
            final ViolationsCollector violationCollector) {
        final var callSign = domain.getRegNumber();
        final var domainFromDb = carLoadPort.loadByRegNumber(domain.getRegNumber());
        if (domainFromDb == null) {
            return;
        }
        if (domainFromDb.getId() == domain.getId()) {
            return;
        }
        violationCollector.collect(
                format("Car with Registration Number %d already exists",
                        callSign));
    }
}
