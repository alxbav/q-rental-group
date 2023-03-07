package ee.qrental.car.application.service;

import ee.qrental.car.application.port.in.mapper.CarResponseMapper;
import ee.qrental.car.application.port.in.mapper.CarUpdateRequestMapper;
import ee.qrental.car.application.port.in.query.GetCarQuery;
import ee.qrental.car.application.port.in.request.CarUpdateRequest;
import ee.qrental.car.application.port.in.response.CarResponse;
import ee.qrental.car.application.port.out.CarLoadPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service

@AllArgsConstructor
public class CarQueryService implements GetCarQuery {

    private final CarLoadPort loadPort;
    private final CarResponseMapper mapper;
    private final CarUpdateRequestMapper updateRequestMapper;

    @Override
    public List<CarResponse> getAll() {
        return loadPort.loadAll()
                .stream()
                .map(mapper::toResponse)
                .collect(toList());
    }

    @Override
    public CarResponse getById(final Long id) {
        return mapper.toResponse(loadPort.loadById(id));
    }

    @Override
    public String getObjectInfo(Long id) {
        return mapper.toObjectInfo(loadPort.loadById(id));
    }

    @Override
    public CarUpdateRequest getUpdateRequestById(Long id) {
        return updateRequestMapper.toRequest(loadPort.loadById(id));
    }
}
