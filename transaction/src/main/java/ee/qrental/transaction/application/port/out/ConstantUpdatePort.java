package ee.qrental.transaction.application.port.out;

import ee.qrental.transaction.domain.Constant;

public interface ConstantUpdatePort {
    Constant updateConstant(Constant constant);
}
