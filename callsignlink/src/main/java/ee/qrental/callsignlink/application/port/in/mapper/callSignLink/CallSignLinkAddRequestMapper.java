package ee.qrental.callsignlink.application.port.in.mapper.callSignLink;

import ee.qrental.callsignlink.application.port.in.request.callsignlink.CallSignLinkAddRequest;
import ee.qrental.callsignlink.domain.CallSignLink;
import ee.qrental.common.core.api.application.mapper.AddRequestMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CallSignLinkAddRequestMapper
        implements AddRequestMapper<CallSignLinkAddRequest, CallSignLink> {

    @Override
    public CallSignLink toDomain(CallSignLinkAddRequest request) {
        final var domain = new CallSignLink();
        domain.setId(null);
        domain.setDriverId(request.getDriverId());
        domain.setCallSignId(request.getCallSignId());
        domain.setDateStart(request.getDateStart());
        domain.setDateEnd(request.getDateEnd());
        domain.setComment(request.getComment());

        return domain;
    }
}