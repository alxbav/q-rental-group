package ee.qrental.transaction.application.service.strategy;

import ee.qrental.transaction.application.port.in.request.transaction.TransactionFilterRequest;
import ee.qrental.transaction.application.port.in.utils.Week;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static ee.qrental.transaction.application.service.strategy.TransactionLoadUtils.getFirstDayOfYear;
import static ee.qrental.transaction.application.service.strategy.TransactionLoadUtils.getLastDayOfYear;


@Component
@AllArgsConstructor
public class TransactionLoadStrategyByYear implements TransactionLoadStrategy {

    private final TransactionLoadPort transactionLoadPort;

    @Override
    public boolean canApply(TransactionFilterRequest request) {
        return request.getDriverId() == null && request.getWeek() == Week.ALL;
    }

    @Override
    public List<Transaction> load(TransactionFilterRequest request) {
        final var year = request.getYear();

        return transactionLoadPort.loadAllBetweenDays(
                getFirstDayOfYear(year),
                getLastDayOfYear(year));
    }
}
