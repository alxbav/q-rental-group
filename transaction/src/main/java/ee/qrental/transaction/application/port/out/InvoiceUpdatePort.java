package ee.qrental.transaction.application.port.out;

import ee.qrental.common.core.api.application.port.UpdatePort;
import ee.qrental.transaction.domain.Invoice;

public interface InvoiceUpdatePort
        extends UpdatePort<Invoice> {
}
