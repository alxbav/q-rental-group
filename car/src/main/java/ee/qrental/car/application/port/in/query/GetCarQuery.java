package ee.qrental.car.application.port.in.query;

import ee.qrental.car.application.port.in.request.CarUpdateRequest;
import ee.qrental.car.application.port.in.response.CarResponse;
import ee.qrental.common.core.api.application.query.BaseGetQuery;


public interface GetCarQuery
        extends BaseGetQuery<CarUpdateRequest, CarResponse> {
}