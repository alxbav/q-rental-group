package ee.qrental.link.application.service;

import ee.qrental.link.application.port.in.mapper.LinkResponseMapper;
import ee.qrental.link.application.port.in.mapper.LinkUpdateRequestMapper;
import ee.qrental.link.application.port.in.query.GetLinkQuery;
import ee.qrental.link.application.port.in.request.LinkUpdateRequest;
import ee.qrental.link.application.port.in.response.LinkResponse;
import ee.qrental.link.application.port.out.LinkLoadPort;
import ee.qrental.link.domain.Link;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class LinkQueryService implements GetLinkQuery {

    private LinkLoadPort loadPort;
    private LinkResponseMapper mapper;

    private LinkUpdateRequestMapper updateRequestMapper;

    @Override
    public List<LinkResponse> getAll() {
        return loadPort.loadAll()
                .stream()
                .map(mapper::toResponse)
                .collect(toList());
    }

    @Override
    public LinkResponse getById(Long id) {
        return mapper.toResponse(loadPort.loadById(id));
    }

    @Override
    public String getObjectInfo(Long id) {
        return mapper.toObjectInfo(loadPort.loadById(id));
    }

    @Override
    public LinkUpdateRequest getUpdateRequestById(Long id) {
        return updateRequestMapper.toRequest(loadPort.loadById(id));
    }

    @Override
    public List<LinkResponse> getActiveLinks() {
        final var activeLinks = new ArrayList<Link>();
        activeLinks.addAll(loadPort.loadByDateEndGreaterThan(LocalDate.now()));
        activeLinks.addAll(loadPort.loadByDateEndIsNull());

        return activeLinks.stream()
                .map(mapper::toResponse)
                .collect(toList());
    }
}
