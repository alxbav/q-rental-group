package ee.qrental.transaction.application.port.out;

import ee.qrental.transaction.domain.TransactionType;

import java.util.List;

public interface TransactionTypeLoadPort {
    List<TransactionType> loadAll();

    TransactionType loadById(Long id);

    TransactionType loadByName(final String name);
}
