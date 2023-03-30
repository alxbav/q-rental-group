package ee.qrental.transaction.application.port.in.query;

import ee.qrental.transaction.application.port.in.response.balance.BalanceResponse;
import ee.qrental.transaction.application.port.in.response.invoice.InvoiceResponse;

import java.math.BigDecimal;
import java.util.List;

public interface GetInvoiceQuery {
    List<InvoiceResponse> getAll();

}
