package ee.qrental.callsignlink.application.port.in.mapper.callSign;

import ee.qrental.callsignlink.application.port.in.request.callsign.CallSignAddRequest;
import ee.qrental.callsignlink.domain.CallSign;
import ee.qrental.common.core.api.mapper.AddRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class CallSignAddRequestMapper implements
        AddRequestMapper<CallSignAddRequest, CallSign> {

    @Override
    public CallSign toDomain(CallSignAddRequest request) {
        final var domain = new CallSign();
        domain.setId(null);
        domain.setCallSign(request.getCallSign());
        domain.setComment(request.getComment());

        return domain;
    }
}
