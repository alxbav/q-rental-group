package ee.qrental.transaction.application.port.out;

import ee.qrental.common.core.api.application.port.LoadPort;
import ee.qrental.transaction.domain.Firm;
import ee.qrental.transaction.domain.Invoice;


import java.time.LocalDate;
import java.util.List;

public interface InvoiceLoadPort
        extends LoadPort<Invoice> {

    Invoice loadById(final Long id);


}
