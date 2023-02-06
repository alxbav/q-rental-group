package ee.qrental.transaction.application.port.out;

import ee.qrental.transaction.domain.TransactionType;

import java.util.List;

public interface TransactionTypeLoadPort {
    List<TransactionType> loadAllTransactionTypes();

    TransactionType loadTransactionTypeById(Long id);
}
