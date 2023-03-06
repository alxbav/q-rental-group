package ee.qrental.callsignlink.application.validator;

import ee.qrental.callsignlink.application.port.out.callsign.CallSignLoadPort;
import ee.qrental.callsignlink.domain.CallSign;
import ee.qrental.common.core.api.application.validation.QValidator;
import ee.qrental.common.core.api.application.validation.ViolationsCollector;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
@AllArgsConstructor
public class CallSignBusinessRuleValidator implements QValidator<CallSign> {

    private final CallSignLoadPort callSignLoadPort;

    @Override
    public ViolationsCollector validate(final CallSign domain) {
        final var violationsCollector = new ViolationsCollector();
        checkUniqueness(domain, violationsCollector);

        return violationsCollector;
    }

    private void checkUniqueness(final CallSign domain, final ViolationsCollector violationCollector) {
        final var callSign = domain.getCallSign();
        final var domainFromDb = callSignLoadPort.loadByCallSign(callSign);
        if (domainFromDb == null) {
            return;
        }
        if (domainFromDb.getId() == domain.getId()) {
            return;
        }
        violationCollector.collect(format("Call Sign %d already exists", callSign));
    }
}
