package ee.qrental.driver.application.port.in.query;

import ee.qrental.common.core.api.query.BaseGetQuery;
import ee.qrental.driver.application.port.in.request.driver.DriverUpdateRequest;
import ee.qrental.driver.application.port.in.response.driver.DriverResponse;

public interface GetDriverQuery
        extends BaseGetQuery<DriverUpdateRequest, DriverResponse> {

}
