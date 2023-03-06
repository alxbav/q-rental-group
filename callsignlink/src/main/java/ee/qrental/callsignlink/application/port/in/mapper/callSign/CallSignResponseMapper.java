package ee.qrental.callsignlink.application.port.in.mapper.callSign;

import ee.qrental.callsignlink.application.port.in.response.CallSignResponse;
import ee.qrental.callsignlink.domain.CallSign;
import ee.qrental.common.core.api.application.mapper.ResponseMapper;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class CallSignResponseMapper
        implements ResponseMapper<CallSignResponse, CallSign> {

    @Override
    public CallSignResponse toResponse(final CallSign domain) {
        final var response = new CallSignResponse();
        response.setId(domain.getId());
        response.setCallSign(domain.getCallSign());
        response.setComment(domain.getComment());

        return response;
    }

    @Override
    public String toObjectInfo(CallSign domain) {
        return format("Call Sign : %d ",
                domain.getCallSign());
    }
}