package ee.qrental.transaction.adapter.out.persistance;

import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.driver.domain.Driver;
import ee.qrental.transaction.application.port.out.BalanceLoadPort;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.application.port.out.dto.BalanceResource;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@Component
@AllArgsConstructor
public class BalanceAdapter implements BalanceLoadPort {

    private final DriverLoadPort driverLoadPort;

    private final TransactionLoadPort transactionLoadPort;

    @Override
    public List<BalanceResource> loadBalances() {
        return driverLoadPort.loadAllDrivers()
                .stream()
                .map(driver -> byDriver(driver)).collect(toList());
    }

    private BalanceResource byDriver(Driver driver) {
        final var amount = transactionLoadPort.loadTransactionByDriverId(driver.getId())
                .stream()
                .mapToLong(Transaction::getRealAmount)
                .sum();

        return BalanceResource.builder()
                .driverId(driver.getId())
                .firstName(driver.getFirstName())
                .lastName(driver.getLastName())
                .amount(amount)
                .callSign("One")
                .build();
    }
}
