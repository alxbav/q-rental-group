package ee.qrental.calculation.application.service;

import ee.qrental.calculation.application.port.in.mapper.RentCalculationResponseMapper;
import ee.qrental.calculation.application.port.in.query.GetRentCalculationQuery;
import ee.qrental.calculation.application.port.in.response.RentCalculationResponse;
import ee.qrental.calculation.application.port.out.RentCalculationLoadPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service

@AllArgsConstructor
public class RentCalculationQueryService
        implements GetRentCalculationQuery {

    private final RentCalculationLoadPort loadPort;
    private final RentCalculationResponseMapper mapper;

    @Override
    public List<RentCalculationResponse> getAll() {
        return loadPort.loadAll()
                .stream()
                .map(mapper::toResponse)
                .collect(toList());
    }

    @Override
    public String getObjectInfo(Long id) {
        return mapper.toObjectInfo(loadPort.loadById(id));
    }
}
