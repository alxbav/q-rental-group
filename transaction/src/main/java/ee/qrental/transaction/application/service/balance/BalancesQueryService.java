package ee.qrental.transaction.application.service.balance;

import ee.qrental.driver.application.port.in.query.GetDriverQuery;
import ee.qrental.driver.application.port.in.response.driver.DriverResponse;
import ee.qrental.transaction.application.port.in.query.GetBalanceQuery;
import ee.qrental.transaction.application.port.in.response.balance.BalanceResponse;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class BalancesQueryService
        implements GetBalanceQuery {

    private final TransactionLoadPort transactionLoadPort;
    private final GetDriverQuery driverQuery;

    @Override
    public List<BalanceResponse> getAll() {
        return driverQuery.getAll()
                .stream()
                .map(this::getBalanceByDriverId)
                .collect(toList());
    }

    @Override
    public BigDecimal getTotalByDriverId(final Long driverId) {
        return calculateTotal(transactionLoadPort.loadAllByDriverId(driverId));
    }

    private BalanceResponse getBalanceByDriverId(final DriverResponse driver) {
        final var driverId = driver.getId();

        final var total = calculateTotal(transactionLoadPort.loadAllByDriverId(driverId));

        final var balanceResponse = new BalanceResponse();
        balanceResponse.setDriverId(driverId);

        balanceResponse.setTotal(total);
        balanceResponse.setFirstName(driver.getFirstName());
        balanceResponse.setLastName(driver.getLastName());

        return balanceResponse;
    }

    private BigDecimal calculateTotal(final List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getRealAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
