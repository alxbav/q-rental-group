package ee.qrental.transaction.application.port.out;

import ee.qrental.common.core.api.application.port.LoadPort;
import ee.qrental.transaction.domain.Firm;
import ee.qrental.transaction.domain.Transaction;
import ee.qrental.transaction.domain.TransactionType;


import java.util.List;

public interface FirmLoadPort
        extends LoadPort<Firm> {

    Firm loadByName(final String name);
}
