package ee.qrental.transactiontype.application.port.out;

import ee.qrental.transactiontype.domain.TransactionType;

import java.util.List;
import java.util.Optional;

public interface TransactionTypeLoadPort {
    List<TransactionType> loadAllTransactionTypes();

    TransactionType loadTransactionTypeById(Long id);
}
