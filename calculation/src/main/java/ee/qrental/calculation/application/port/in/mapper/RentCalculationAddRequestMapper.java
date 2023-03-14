package ee.qrental.calculation.application.port.in.mapper;


import ee.qrental.common.core.api.application.mapper.AddRequestMapper;
import ee.qrental.calculation.application.port.in.request.RentCalculationAddRequest;
import ee.qrental.calculation.domain.RentCalculation;
import org.springframework.stereotype.Component;

@Component
public class RentCalculationAddRequestMapper
        implements AddRequestMapper<RentCalculationAddRequest, RentCalculation> {

    @Override
    public RentCalculation toDomain(final RentCalculationAddRequest request) {
        final var domain = new RentCalculation();
        domain.setActionDate(request.getActionDate());

        return domain;
    }
}
