package ee.qrental.link.application.port.in.mapper;

import ee.qrental.common.core.api.mapper.ResponseMapper;
import ee.qrental.link.application.port.in.response.LinkResponse;
import ee.qrental.link.domain.Link;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class LinkResponseMapper
        implements ResponseMapper<LinkResponse, Link> {

    @Override
    public LinkResponse toResponse(final Link domain) {
        final var response = new LinkResponse();
        response.setId(domain.getId());
        response.setDriverId(domain.getDriverId());
        response.setCarId(domain.getCarId());
        response.setDateStart(domain.getDateStart());
        response.setDateEnd(domain.getDateEnd());
        response.setComment(domain.getComment());

        return response;
    }

    @Override
    public String toObjectInfo(Link domain) {
        //TODO add Driver load Port and Car Load Port, to show data, but not IDs
        return format("Link for driver: %s and car: %s, started on: , ended on: .",
                domain.getDriverId(),
                domain.getCarId(),
                domain.getDateStart(),
                domain.getDateEnd());
    }
}
