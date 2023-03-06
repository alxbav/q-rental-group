package ee.qrental.driver.application.service.driver;

import ee.qrental.driver.application.port.in.mapper.driver.DriverResponseMapper;
import ee.qrental.driver.application.port.in.mapper.driver.DriverUpdateRequestMapper;
import ee.qrental.driver.application.port.in.query.GetDriverQuery;
import ee.qrental.driver.application.port.in.request.driver.DriverUpdateRequest;
import ee.qrental.driver.application.port.in.response.driver.DriverResponse;
import ee.qrental.driver.application.port.out.DriverLoadPort;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class DriverQueryService implements GetDriverQuery {

    private final DriverLoadPort loadPort;
    private final DriverResponseMapper mapper;
    private final DriverUpdateRequestMapper updateRequestMapper;

    @Override
    public List<DriverResponse> getAll() {
        return loadPort.loadAll()
                .stream()
                .map(mapper::toResponse)
                .collect(toList());
    }

    @Override
    public DriverResponse getById(final Long id) {
        return mapper.toResponse(loadPort.loadById(id));
    }

    @Override
    public String getObjectInfo(Long id) {
        return mapper.toObjectInfo(loadPort.loadById(id));
    }

    @Override
    public DriverUpdateRequest getUpdateRequestById(Long id) {
        return updateRequestMapper.toRequest(loadPort.loadById(id));
    }


}
