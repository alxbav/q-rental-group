package ee.qrental.callsignlink.application.port.in.mapper.callSignLink;

import ee.qrental.callsignlink.application.port.in.request.callsignlink.CallSignLinkUpdateRequest;
import ee.qrental.callsignlink.domain.CallSignLink;
import ee.qrental.common.core.api.mapper.UpdateRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class CallSignLinkUpdateRequestMapper
        implements UpdateRequestMapper<CallSignLinkUpdateRequest, CallSignLink> {

    @Override
    public CallSignLink toDomain(final CallSignLinkUpdateRequest request) {
        final var domain = new CallSignLink();
        domain.setId(request.getId());
        domain.setCallSignId(request.getCallSignId());
        domain.setDriverId(request.getDriverId());
        domain.setDateStart(request.getDateStart());
        domain.setDateEnd(request.getDateEnd());
        domain.setComment(request.getComment());

        return domain;
    }

    @Override
    public CallSignLinkUpdateRequest toRequest(final CallSignLink domain) {
        final var request = new CallSignLinkUpdateRequest();
        request.setId(domain.getId());
        request.setCallSignId(domain.getCallSignId());
        request.setDateStart(domain.getDateStart());
        request.setDateEnd(domain.getDateEnd());
        request.setComment(domain.getComment());

        return request;
    }
}
