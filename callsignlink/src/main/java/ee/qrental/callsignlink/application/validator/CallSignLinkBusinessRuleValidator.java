package ee.qrental.callsignlink.application.validator;

import ee.qrental.callsignlink.application.port.out.callsign.CallSignLoadPort;
import ee.qrental.callsignlink.application.port.out.callsignlink.CallSignLinkLoadPort;
import ee.qrental.callsignlink.domain.CallSignLink;
import ee.qrental.common.core.api.validation.QValidator;
import ee.qrental.common.core.api.validation.ViolationsCollector;
import ee.qrental.driver.application.port.out.DriverLoadPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.lang.String.format;

@Component
@AllArgsConstructor
public class CallSignLinkBusinessRuleValidator implements QValidator<CallSignLink> {

    private final CallSignLinkLoadPort callSignLinkLoadPort;
    private final CallSignLoadPort callSignLoadPort;
    private final DriverLoadPort driverLoadPort;

    @Override
    public ViolationsCollector validate(final CallSignLink domain) {
        final var violationsCollector = new ViolationsCollector();
        final var activeCallSignLinks = callSignLinkLoadPort.loadActiveCallSignLinks();
        checkCallSign(domain, violationsCollector, activeCallSignLinks);
        checkDriver(domain, violationsCollector, activeCallSignLinks);

        return violationsCollector;
    }

    private void checkCallSign(final CallSignLink domain,
                               final ViolationsCollector violationCollector,
                               final List<CallSignLink> activeCallSignLinks) {
        final var callSignId = domain.getCallSignId();
        final var callSignLinkByCallSignOpt = activeCallSignLinks
                .stream()
                .filter(callSignLink -> callSignLink.getCallSignId().equals(callSignId))
                .findFirst();
        if (callSignLinkByCallSignOpt.isEmpty()) {
            return;
        }
        if (callSignLinkByCallSignOpt.get().getId().equals(domain.getId())) {
            return;
        }
        final var callSign = callSignLoadPort.loadById(callSignId);
        violationCollector.collect(format("Call Sign: '%d' is active and can not be linked.",
                callSign.getCallSign()));
    }

    private void checkDriver(final CallSignLink domain,
                             final ViolationsCollector violationCollector,
                             final List<CallSignLink> activeCallSignLinks) {
        final var driverId = domain.getDriverId();
        final var callSignLinkByDriverOpt = activeCallSignLinks
                .stream()
                .filter(callSignLink -> callSignLink.getDriverId().equals(driverId))
                .findFirst();
        if (callSignLinkByDriverOpt.isEmpty()) {
            return;
        }
        if (callSignLinkByDriverOpt.get().getId().equals(domain.getId())) {
            return;
        }
        final var driver = driverLoadPort.loadById(driverId);
        violationCollector.collect(format("Driver: %s %s already has an active Call Sign.",
                driver.getLastName(), driver.getFirstName()));
    }
}
