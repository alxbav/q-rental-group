package ee.qrental.transaction.application.service;

import ee.qrental.common.core.api.mapper.ResponseMapper;
import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.driver.domain.Driver;
import ee.qrental.transaction.application.port.in.query.GetBalanceQuery;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionUpdateRequest;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionWeekAndDriverFilterRequest;
import ee.qrental.transaction.application.port.in.response.balance.BalanceDetailResponse;
import ee.qrental.transaction.application.port.in.response.balance.BalanceResponse;
import ee.qrental.transaction.application.port.in.response.transaction.TransactionResponse;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;

import java.util.List;

import static java.lang.String.format;
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
    public BalanceDetailResponse getDetailedBalanceBySearchRequest(
            final TransactionWeekAndDriverFilterRequest searchRequest) {
        //TODO In progress by Oleg
        final var driverTransactions = transactionLoadPort.loadAllByDriverIdAndBetweenDays(
                searchRequest.getDriverId(),
                null, null);
        final var total = calculateTotal(driverTransactions);
        final var driverTransactionResponses = driverTransactions
                .stream()
                .map(mapper::toResponse)
                .collect(toList());
        final var driver = driverLoadPort.loadById(searchRequest.getDriverId());

        final var balanceResponse = new BalanceDetailResponse();
        balanceResponse.setDriverInfo(
                format("%s %s", driver.getFirstName(), driver.getLastName()));
        balanceResponse.setTotal(total);
        balanceResponse.setTransactions(driverTransactionResponses);

        return balanceResponse;
    }

    @Override
    public BalanceDetailResponse getDetailedBalanceByDriverId(final Long driverId) {
        final var driverTransactions = transactionLoadPort.loadAllByDriverId(driverId);
        final var total = calculateTotal(driverTransactions);
        final var driverTransactionResponses = driverTransactions
                .stream()
                .map(mapper::toResponse)
                .collect(toList());
        final var driver = driverLoadPort.loadById(driverId);

        final var balanceResponse = new BalanceDetailResponse();
        balanceResponse.setDriverInfo(
                format("%s %s", driver.getFirstName(), driver.getLastName()));
        balanceResponse.setTotal(total);
        balanceResponse.setTransactions(driverTransactionResponses);

        return balanceResponse;
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
