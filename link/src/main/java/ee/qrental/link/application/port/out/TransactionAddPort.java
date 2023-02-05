package ee.qrental.link.application.port.out;

import ee.qrental.link.domain.Link;

public interface TransactionAddPort {
    Link addTransaction(Link link);
}
