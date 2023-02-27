package ee.qrental.link.application.port.in.mapper;

import ee.qrental.common.core.api.mapper.AddRequestMapper;
import ee.qrental.link.application.port.in.request.LinkAddRequest;
import ee.qrental.link.domain.Link;
import org.springframework.stereotype.Component;

@Component
public class LinkAddRequestMapper
        implements AddRequestMapper<LinkAddRequest, Link> {
    @Override
    public Link toDomain(final LinkAddRequest request) {
        return new Link(
                null,
                request.getCarId(),
                request.getDriverId(),
                request.getDateStart(),
                request.getDateEnd(),
                request.getComment());
    }
}
