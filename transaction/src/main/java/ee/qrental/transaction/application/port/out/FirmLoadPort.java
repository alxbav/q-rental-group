package ee.qrental.transaction.application.port.out;

import ee.qrental.common.core.api.application.port.LoadPort;
import ee.qrental.transaction.domain.Firm;

public interface FirmLoadPort
        extends LoadPort<Firm> {

    Firm loadByName(final String name);
}
