package ee.qrental.callsignlink.application.port.in.query;

import ee.qrental.callsignlink.application.port.in.request.callsign.CallSignUpdateRequest;
import ee.qrental.callsignlink.application.port.in.response.CallSignResponse;
import ee.qrental.common.core.api.application.query.BaseGetQuery;


public interface GetCallSignQuery
        extends BaseGetQuery<CallSignUpdateRequest, CallSignResponse> {
}