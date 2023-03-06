package ee.qrental.transaction.application.port.out;

import ee.qrental.common.core.api.application.port.UpdatePort;
import ee.qrental.transaction.domain.Transaction;

public interface TransactionUpdatePort
        extends UpdatePort<Transaction> {
}
