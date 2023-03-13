package ee.qrental.transaction.application.service.firm;

import ee.qrental.transaction.application.port.in.mapper.firm.FirmResponseMapper;
import ee.qrental.transaction.application.port.in.mapper.firm.FirmUpdateRequestMapper;
import ee.qrental.transaction.application.port.in.query.GetFirmQuery;
import ee.qrental.transaction.application.port.in.request.firm.FirmUpdateRequest;
import ee.qrental.transaction.application.port.in.response.firm.FirmResponse;
import ee.qrental.transaction.application.port.out.FirmLoadPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class FirmQueryService
        implements GetFirmQuery {

    private final FirmLoadPort loadPort;
    private final FirmResponseMapper mapper;
    private final FirmUpdateRequestMapper updateRequestMapper;

    @Override
    public List<FirmResponse> getAll() {
        return loadPort.loadAll()
                .stream()
                .map(mapper::toResponse)
                .collect(toList());
    }

    @Override
    public FirmResponse getById(final Long id) {
        return mapper.toResponse(loadPort.loadById(id));
    }

    @Override
    public String getObjectInfo(Long id) {
        return mapper.toObjectInfo(loadPort.loadById(id));
    }

    @Override
    public FirmUpdateRequest getUpdateRequestById(Long id) {
        return updateRequestMapper.toRequest(loadPort.loadById(id));
    }

    @Override
    public FirmResponse getByName(final String name) {
        return mapper.toResponse(loadPort.loadByName(name));
    }
}
