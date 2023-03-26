package ee.qrental.transaction.application.port.out;

import ee.qrental.common.core.api.application.port.AddPort;
import ee.qrental.transaction.domain.Invoice;


public interface InvoiceAddPort
        extends AddPort<Invoice> {
}
