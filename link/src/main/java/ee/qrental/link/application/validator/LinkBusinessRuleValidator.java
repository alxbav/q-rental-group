package ee.qrental.link.application.validator;

import ee.qrental.common.core.api.application.validation.QValidator;
import ee.qrental.common.core.api.application.validation.ViolationsCollector;
import ee.qrental.driver.application.port.in.query.GetDriverQuery;
import ee.qrental.link.domain.Link;
import ee.qrental.transaction.application.port.in.query.GetTransactionQuery;
import ee.qrental.transaction.application.port.in.response.transaction.TransactionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

import static java.lang.String.format;

@Component

@AllArgsConstructor
public class LinkBusinessRuleValidator
        implements QValidator<Link> {

    private final GetDriverQuery driverQuery;
    private final GetTransactionQuery transactionQuery;

    @Override
    public ViolationsCollector validate(final Link link) {
        final var violationsCollector = new ViolationsCollector();
        checkDriverAvailability(link, violationsCollector);
        checkDriverBalance(link, violationsCollector);

        return violationsCollector;
    }

    private void checkDriverAvailability(final Link domain, final ViolationsCollector violationCollector) {
        final var driverId = domain.getDriverId();
        final var driver = driverQuery.getById(driverId);
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
        final var weeklyRent = 0;
        final var weeklyCasco = 0;
        final var requiredDeposit = weeklyRent + weeklyCasco;
        final var total = getTotalByDriverId(driverId);
        if (total.compareTo(BigDecimal.valueOf(requiredDeposit)) < 0) {
            violationsCollector.collect(
                    format("Driver does not have enough founds, required: %d EURO (current founds: %d EURO)",
                            requiredDeposit, total));
        }
    }

    private BigDecimal getTotalByDriverId(final Long driverId) {
        return calculateTotal(transactionQuery.getAllByDriverId(driverId));
    }

    private BigDecimal calculateTotal(final List<TransactionResponse> transactions) {
        return transactions.stream()
                .map(TransactionResponse::getRealAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
