package ee.qrental.calculation.application.port.out;

import ee.qrental.common.core.api.application.port.LoadPort;
import ee.qrental.calculation.domain.RentCalculation;

public interface RentCalculationLoadPort
        extends LoadPort<RentCalculation> {
    RentCalculation loadLastCalculation();
}
