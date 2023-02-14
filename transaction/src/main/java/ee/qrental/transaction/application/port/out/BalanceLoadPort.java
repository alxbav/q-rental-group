package ee.qrental.transaction.application.port.out;

import ee.qrental.transaction.application.port.out.dto.BalanceResource;

import java.util.List;

public interface BalanceLoadPort {
    List<BalanceResource> loadBalances();
}
