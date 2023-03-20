package ee.qrental.link.application.port.in.mapper;

import ee.qrental.callsignlink.application.port.in.query.GetCallSignLinkQuery;
import ee.qrental.callsignlink.application.port.in.query.GetCallSignQuery;
import ee.qrental.common.core.api.application.mapper.ResponseMapper;
import ee.qrental.link.application.port.in.response.LinkResponse;
import ee.qrental.link.domain.Link;
import ee.qrental.driver.application.port.in.query.GetDriverQuery;
import ee.qrental.car.application.port.in.query.GetCarQuery;
import ee.qrental.callsignlink.application.port.out.callsign.CallSignLoadPort;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;

import static java.lang.String.format;

@Component

@AllArgsConstructor
public class LinkResponseMapper
        implements ResponseMapper<LinkResponse, Link> {

    private final GetCallSignLinkQuery callSignLinkQuery;
    private final GetDriverQuery driverQuery;
    private final GetCarQuery carQuery;

    @Override
    public LinkResponse toResponse(final Link domain) {
        final var callSignLinkResponse = callSignLinkQuery.getCallSignLinkByDriverId(
                domain.getDriverId());
        final var driverInfo = driverQuery.getObjectInfo(domain.getDriverId());
        final var carInfo = carQuery.getObjectInfo(domain.getCarId());
        final var response = new LinkResponse();

        response.setId(domain.getId());
        response.setDriverId(domain.getDriverId());
        response.setDriverInfo(driverInfo);
        response.setCallSign(callSignLinkResponse.getCallSign());
        response.setCarId(domain.getCarId());
        response.setCarInfo(carInfo);
        response.setDateStart(domain.getDateStart());
        response.setDateEnd(domain.getDateEnd());
        response.setComment(domain.getComment());

        return response;
    }

    @Override
    public String toObjectInfo(Link domain) {
        //TODO add Driver load Port and Car Load Port, to show data, but not IDs
        final var driverInfo = driverQuery.getObjectInfo(domain.getDriverId());
        final var carInfo = carQuery.getObjectInfo(domain.getCarId());
        return format("Link for driver: %s and car: %s, started on: , ended on: .",
                driverInfo,
                carInfo,
                domain.getCarId(),
                domain.getDateStart(),
                domain.getDateEnd());
    }
}
