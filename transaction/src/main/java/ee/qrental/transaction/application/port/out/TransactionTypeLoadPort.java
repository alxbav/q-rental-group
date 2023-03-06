package ee.qrental.transaction.application.port.out;

import ee.qrental.common.core.api.application.port.LoadPort;
import ee.qrental.transaction.domain.TransactionType;

import java.util.List;

public interface TransactionTypeLoadPort
        extends LoadPort<TransactionType> {

    TransactionType loadByName(final String name);
}
