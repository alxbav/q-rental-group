package ee.qrental.transaction.adapter.out.persistance;

import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.driver.domain.Driver;
import ee.qrental.transaction.application.port.in.response.BalanceResponse;
import ee.qrental.transaction.application.port.out.BalanceLoadPort;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class BalanceAdapter implements BalanceLoadPort {

    private final DriverLoadPort driverLoadPort;

    private final TransactionLoadPort transactionLoadPort;

    @Override
    public List<BalanceResponse> loadBalances() {
        return driverLoadPort.loadAllDrivers()
                .stream()
                .map(driver -> byDriver(driver)).collect(toList());
    }

    private BalanceResponse byDriver(Driver driver) {
        final var amount = transactionLoadPort.loadAllByDriverId(driver.getId())
                .stream()
                .mapToLong(Transaction::getRealAmount)
                .sum();

        return BalanceResponse.builder()
                .driverId(driver.getId())
                .firstName(driver.getFirstName())
                .lastName(driver.getLastName())
                .amount(amount)
                .callSign("One")
                .build();
    }
}
