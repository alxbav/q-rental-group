package ee.qrental.link.adapter.out.persistance.adapter;

import ee.qrental.link.adapter.out.persistance.mapper.LinkMapper;
import ee.qrental.link.adapter.out.persistance.repository.SpringDataLinkRepository;
import ee.qrental.link.application.port.out.LinkAddPort;
import ee.qrental.link.application.port.out.LinkDeletePort;
import ee.qrental.link.application.port.out.LinkLoadPort;
import ee.qrental.link.application.port.out.LinkUpdatePort;
import ee.qrental.link.domain.Link;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class LinkLoadAdapter
        implements LinkLoadPort {

    private final SpringDataLinkRepository springDataLinkRepository;
    private final LinkMapper linkMapper;

    @Override
    public List<Link> loadAll() {
        return springDataLinkRepository.findAll()
                .stream()
                .map(linkMapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public Link loadById(Long id) {
        return linkMapper.mapToDomain(
                springDataLinkRepository.getReferenceById(id));
    }

    @Override
    public List<Link> loadByDateEndGreaterThan(final LocalDate dateEnd) {
        return springDataLinkRepository.findAllByDateEndGreaterThan(dateEnd)
                .stream()
                .map(linkMapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public List<Link> loadByDateEndIsNull() {
        return springDataLinkRepository.findAllByDateEndIsNull()
                .stream()
                .map(linkMapper::mapToDomain)
                .collect(toList());
    }
}
