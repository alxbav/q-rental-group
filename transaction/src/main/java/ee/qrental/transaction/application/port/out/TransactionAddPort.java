package ee.qrental.transaction.application.port.out;

import ee.qrental.common.core.api.application.port.AddPort;
import ee.qrental.transaction.domain.Transaction;

public interface TransactionAddPort
        extends AddPort<Transaction> {
}
