package ee.qrental.callsignlink.application.port.in.query;

import ee.qrental.callsignlink.application.port.in.request.callsignlink.CallSignLinkUpdateRequest;
import ee.qrental.callsignlink.application.port.in.response.CallSignLinkResponse;
import ee.qrental.common.core.api.application.query.BaseGetQuery;

public interface GetCallSignLinkQuery
        extends BaseGetQuery<CallSignLinkUpdateRequest, CallSignLinkResponse> {
}