package ee.qrental.calculation.application.port.in.mapper;

import ee.qrental.common.core.api.application.mapper.ResponseMapper;
import ee.qrental.calculation.application.port.in.response.RentCalculationResponse;
import ee.qrental.calculation.domain.RentCalculation;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class RentCalculationResponseMapper
        implements ResponseMapper<RentCalculationResponse, RentCalculation> {

    @Override
    public RentCalculationResponse toResponse(final RentCalculation domain) {
        final var response = new RentCalculationResponse();
        response.setId(domain.getId());
        response.setActionDate(domain.getActionDate());
        response.setTransactionCount(domain.getResults().size());
        response.setComment(domain.getComment());

        return response;
    }

    @Override
    public String toObjectInfo(RentCalculation domain) {
        return format("Rent Calculation made on %s, and produced: %d transactions.",
                domain.getActionDate(),
                domain.getResults().size());
    }
}
