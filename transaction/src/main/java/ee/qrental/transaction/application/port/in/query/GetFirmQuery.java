package ee.qrental.transaction.application.port.in.query;

import ee.qrental.common.core.api.application.query.BaseGetQuery;
import ee.qrental.transaction.application.port.in.request.firm.FirmUpdateRequest;
import ee.qrental.transaction.application.port.in.response.firm.FirmResponse;

public interface GetFirmQuery
        extends BaseGetQuery<FirmUpdateRequest, FirmResponse> {

}
