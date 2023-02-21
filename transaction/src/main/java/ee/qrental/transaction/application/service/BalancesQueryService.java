package ee.qrental.transaction.application.service;

import ee.qrental.common.core.api.mapper.ResponseMapper;
import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.driver.domain.Driver;
import ee.qrental.transaction.application.port.in.query.GetBalanceQuery;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionUpdateRequest;
import ee.qrental.transaction.application.port.in.response.balance.BalanceResponse;
import ee.qrental.transaction.application.port.in.response.transaction.TransactionResponse;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
public class BalancesQueryService implements GetBalanceQuery {

    private final TransactionLoadPort transactionLoadPort;
    private final DriverLoadPort driverLoadPort;

    private final ResponseMapper<TransactionUpdateRequest, TransactionResponse, Transaction> mapper;

    @Override
    public List<BalanceResponse> getAll() {
        return driverLoadPort.loadAll()
                .stream()
                .map(this::getBalanceByDriverId)
                .collect(toList());
    }

    @Override
    public Long getTotalByDriverId(Long driverId) {
        return calculateTotal(transactionLoadPort.loadAllByDriverId(driverId));
    }

    private BalanceResponse getBalanceByDriverId(final Driver driver) {
        final var driverId = driver.getId();
        final var total = calculateTotal(transactionLoadPort.loadAllByDriverId(driverId));
        final var balanceResponse = new BalanceResponse();
        balanceResponse.setDriverId(driverId);
        balanceResponse.setTotal(total);
        balanceResponse.setFirstName(driver.getFirstName());
        balanceResponse.setLastName(driver.getLastName());

        return balanceResponse;
    }

    private Long calculateTotal(final List<Transaction> transactions) {
        return transactions.stream()
                .mapToLong(Transaction::getRealAmount)
                .sum();
    }
}
