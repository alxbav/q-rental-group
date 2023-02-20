package ee.qrental.transaction.application.port.out;

import ee.qrental.common.core.api.port.UpdatePort;
import ee.qrental.transaction.domain.Firm;
import ee.qrental.transaction.domain.TransactionType;

public interface FirmUpdatePort
        extends UpdatePort<Firm> {
}
