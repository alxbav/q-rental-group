package ee.qrental.callsignlink.application.service;

import ee.qrental.callsignlink.application.port.in.mapper.callSignLink.CallSignLinkResponseMapper;
import ee.qrental.callsignlink.application.port.in.mapper.callSignLink.CallSignLinkUpdateRequestMapper;
import ee.qrental.callsignlink.application.port.in.query.GetCallSignLinkQuery;
import ee.qrental.callsignlink.application.port.in.request.callsignlink.CallSignLinkUpdateRequest;
import ee.qrental.callsignlink.application.port.in.response.CallSignLinkResponse;
import ee.qrental.callsignlink.application.port.out.callsignlink.CallSignLinkLoadPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class CallSignLinkQueryService implements GetCallSignLinkQuery {

    private final CallSignLinkLoadPort loadPort;
    private final CallSignLinkResponseMapper mapper;
    private final CallSignLinkUpdateRequestMapper updateRequestMapper;

    @Override
    public List<CallSignLinkResponse> getAll() {
        return loadPort.loadAll()
                .stream()
                .map(mapper::toResponse)
                .collect(toList());
    }

    @Override
    public CallSignLinkResponse getById(final Long id) {
        return mapper.toResponse(loadPort.loadById(id));
    }

    @Override
    public String getObjectInfo(Long id) {
        return mapper.toObjectInfo(loadPort.loadById(id));
    }

    @Override
    public CallSignLinkUpdateRequest getUpdateRequestById(Long id) {
        return updateRequestMapper.toRequest(loadPort.loadById(id));
    }
}
