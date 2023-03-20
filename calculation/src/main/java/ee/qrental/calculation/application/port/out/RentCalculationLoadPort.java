package ee.qrental.calculation.application.port.out;

import ee.qrental.calculation.domain.RentCalculation;
import ee.qrental.common.core.api.application.port.LoadPort;

import java.time.LocalDate;
import java.util.Optional;

public interface RentCalculationLoadPort
        extends LoadPort<RentCalculation> {

    Optional<RentCalculation> loadLastCalculationFromDateByLinkId(
            final LocalDate fromDate,
            final Long linkId);

}
