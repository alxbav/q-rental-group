package ee.qrental.transaction.application.port.out;

import ee.qrental.transaction.domain.Firm;
import ee.qrental.transaction.domain.TransactionType;

import java.util.List;

public interface FirmLoadPort {
    List<Firm> loadAll();

    Firm loadById(Long id);
}
