package ee.qrental.link.application.validator;

import ee.qrental.common.core.api.validation.QValidator;
import ee.qrental.common.core.api.validation.ViolationsCollector;
import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.link.domain.Link;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.lang.String.format;

@Component
@AllArgsConstructor
public class LinkBusinessRuleValidator implements QValidator<Link> {

    private final DriverLoadPort driverLoadPort;
    private final TransactionLoadPort transactionLoadPort;

    @Override
    public ViolationsCollector validate(final Link link) {
        final var violationsCollector = new ViolationsCollector();
        checkDriverAvailability(link, violationsCollector);
        checkDriverBalance(link, violationsCollector);

        return violationsCollector;
    }

    private void checkDriverAvailability(final Link domain, final ViolationsCollector violationCollector) {
        final var driverId = domain.getDriverId();
        final var driver = driverLoadPort.loadById(driverId);
        if (driver == null) {
            violationCollector.collect(format("Driver with id = %d does not exist", driverId));
            return;
        }
        if (!driver.getActive()) {
            violationCollector.collect(
                    format("Driver %s %s is inactive",
                            driver.getLastName(),
                            driver.getFirstName()));
        }
    }

    private void checkDriverBalance(final Link domain, final ViolationsCollector violationsCollector) {
        final var driverId = domain.getDriverId();
        final var weeklyRent = 200;
        final var requiredDeposit = 200 + weeklyRent;
        final var total = getTotalByDriverId(driverId);
        if (total < requiredDeposit) {
            violationsCollector.collect(
                    format("Driver does not have enough founds, required: %d EURO (current founds: %d EURO)",
                            requiredDeposit, total));
        }
    }

    //TODO refactor!!!
    private Long getTotalByDriverId(final Long driverId) {
        return calculateTotal(transactionLoadPort.loadAllByDriverId(driverId));
    }

    private Long calculateTotal(final List<Transaction> transactions) {
        return transactions.stream()
                .mapToLong(Transaction::getRealAmount)
                .sum();
    }
}
