package ee.qrental.callsignlink.application.port.in.mapper.callSign;

import ee.qrental.callsignlink.application.port.in.request.callsign.CallSignUpdateRequest;
import ee.qrental.callsignlink.domain.CallSign;
import ee.qrental.common.core.api.application.mapper.UpdateRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class CallSignUpdateRequestMapper
        implements UpdateRequestMapper<CallSignUpdateRequest, CallSign> {

    @Override
    public CallSign toDomain(final CallSignUpdateRequest request) {
        final var domain = new CallSign();
        domain.setId(request.getId());
        domain.setCallSign(request.getCallSign());
        domain.setComment(request.getComment());

        return domain;
    }

    @Override
    public CallSignUpdateRequest toRequest(final CallSign domain) {
        final var request = new CallSignUpdateRequest();
        request.setId(domain.getId());
        request.setCallSign(domain.getCallSign());
        request.setComment(domain.getComment());

        return request;
    }
}
