package ee.qrental.link.application.port.out;

import ee.qrental.link.domain.Link;

import java.util.List;

public interface TransactionLoadPort {
    List<Link> loadAllTransactions();

    Link loadTransactionById(Long id);
}
