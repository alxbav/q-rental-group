package ee.qrental.calculation.application.port.in.query;


import ee.qrental.calculation.application.port.in.response.RentCalculationResponse;

import java.util.List;

public interface GetRentCalculationQuery {
    List<RentCalculationResponse> getAll();

    String getObjectInfo(final Long id);
}