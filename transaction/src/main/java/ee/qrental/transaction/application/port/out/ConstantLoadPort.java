package ee.qrental.transaction.application.port.out;

import ee.qrental.transaction.domain.Constant;

import java.util.List;

public interface ConstantLoadPort {
    List<Constant> loadAllConstants();

    Constant loadConstantById(Long id);

    Constant loadConstantByName(final String name);
}
