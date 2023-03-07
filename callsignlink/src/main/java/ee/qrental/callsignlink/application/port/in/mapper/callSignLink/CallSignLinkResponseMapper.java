package ee.qrental.callsignlink.application.port.in.mapper.callSignLink;

import ee.qrental.callsignlink.application.port.in.query.GetCallSignQuery;
import ee.qrental.callsignlink.application.port.in.response.CallSignLinkResponse;
import ee.qrental.callsignlink.application.port.out.callsign.CallSignLoadPort;
import ee.qrental.callsignlink.domain.CallSignLink;
import ee.qrental.common.core.api.application.mapper.ResponseMapper;
import ee.qrental.driver.application.port.in.query.GetDriverQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component

@AllArgsConstructor
public class CallSignLinkResponseMapper
        implements ResponseMapper<CallSignLinkResponse, CallSignLink> {

    private final CallSignLoadPort callSignLoadPort;
    private final GetDriverQuery driverQuery;

    @Override
    public CallSignLinkResponse toResponse(final CallSignLink domain) {
        final var callSign = callSignLoadPort.loadById(domain.getCallSignId());
        final var driverInfo = driverQuery.getObjectInfo(domain.getDriverId());
        final var response = new CallSignLinkResponse();
        response.setId(domain.getId());
        response.setCallSign(callSign.getCallSign());
        response.setCallSignId(callSign.getId());
        response.setDriverId(domain.getDriverId());
        response.setDriverInfo(driverInfo);
        response.setDateStart(domain.getDateStart());
        response.setDateEnd(domain.getDateEnd());
        response.setComment(domain.getComment());

        return response;
    }

    @Override
    public String toObjectInfo(CallSignLink domain) {
        final var driverInfo = driverQuery.getObjectInfo(domain.getDriverId());
        return format("Call Sign Link for Driver %s. From %s till %s.",
                driverInfo,
                domain.getDateStart(),
                domain.getDateEnd());
    }
}
