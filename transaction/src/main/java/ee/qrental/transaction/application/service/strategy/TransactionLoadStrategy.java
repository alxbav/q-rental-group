package ee.qrental.transaction.application.service.strategy;

import ee.qrental.transaction.application.port.in.request.transaction.TransactionFilterRequest;
import ee.qrental.transaction.domain.Transaction;

import java.util.List;

public interface TransactionLoadStrategy {
    boolean canApply(final TransactionFilterRequest request);

    List<Transaction> load(final TransactionFilterRequest request);
}
