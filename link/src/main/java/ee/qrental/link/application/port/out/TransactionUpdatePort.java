package ee.qrental.link.application.port.out;

import ee.qrental.link.domain.Link;

public interface TransactionUpdatePort {
    Link updateTransaction(Link link);
}
