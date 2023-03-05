package ee.qrental.callsignlink.application.service;

import ee.qrental.callsignlink.application.port.in.mapper.callSign.CallSignResponseMapper;
import ee.qrental.callsignlink.application.port.in.mapper.callSign.CallSignUpdateRequestMapper;
import ee.qrental.callsignlink.application.port.in.query.GetCallSignQuery;
import ee.qrental.callsignlink.application.port.in.request.callsign.CallSignUpdateRequest;
import ee.qrental.callsignlink.application.port.in.response.CallSignResponse;
import ee.qrental.callsignlink.application.port.out.callsign.CallSignLoadPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class CallSignQueryService implements GetCallSignQuery {

    private final CallSignLoadPort loadPort;
    private final CallSignResponseMapper mapper;
    private final CallSignUpdateRequestMapper updateRequestMapper;

    @Override
    public List<CallSignResponse> getAll() {
        return loadPort.loadAll()
                .stream()
                .map(mapper::toResponse)
                .collect(toList());
    }

    @Override
    public CallSignResponse getById(final Long id) {
        return mapper.toResponse(loadPort.loadById(id));
    }

    @Override
    public String getObjectInfo(Long id) {
        return mapper.toObjectInfo(loadPort.loadById(id));
    }

    @Override
    public CallSignUpdateRequest getUpdateRequestById(Long id) {
        return updateRequestMapper.toRequest(loadPort.loadById(id));
    }
}
