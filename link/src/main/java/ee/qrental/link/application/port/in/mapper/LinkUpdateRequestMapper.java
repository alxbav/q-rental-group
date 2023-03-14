package ee.qrental.link.application.port.in.mapper;

import ee.qrental.common.core.api.application.mapper.UpdateRequestMapper;
import ee.qrental.link.application.port.in.request.LinkUpdateRequest;
import ee.qrental.link.domain.Link;
import org.springframework.stereotype.Component;

@Component
public class LinkUpdateRequestMapper
        implements UpdateRequestMapper<LinkUpdateRequest, Link> {
    @Override
    public Link toDomain(LinkUpdateRequest request) {
        return new Link(
                request.getId(),
                request.getCarId(),
                request.getDriverId(),
                request.getDateStart(),
                request.getDateEnd(),
                request.getComment()
        );
    }

    @Override
    public LinkUpdateRequest toRequest(final Link domain) {
        final var request = new LinkUpdateRequest();
        request.setId(domain.getId());
        request.setDriverId(domain.getDriverId());
        request.setCarId(domain.getCarId());
        request.setDateStart(domain.getDateStart());
        request.setDateEnd(domain.getDateEnd());
        request.setComment(domain.getComment());

        return request;
    }
}
