package ee.qrental.link.adapter.out.persistance;

import ee.qrental.link.domain.Link;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ee.qrental.link.application.port.out.LinkAddPort;
import ee.qrental.link.application.port.out.LinkDeletePort;
import ee.qrental.link.application.port.out.LinkLoadPort;
import ee.qrental.link.application.port.out.LinkUpdatePort;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class LinkPersistenceAdapterLoadAddUpdateDelete implements
        LinkLoadPort,
        LinkAddPort,
        LinkUpdatePort,
        LinkDeletePort {

    private final SpringDataLinkRepository springDataLinkRepository;
    private final LinkMapper linkMapper;

    @Override
    public List<Link> loadAllLinks() {
        return springDataLinkRepository.findAll()
                .stream()
                .map(linkMapper::mapToDomain)
                .collect(toList());
    }

       @Override
    public Link loadLinkById(Long id) {
        return linkMapper.mapToDomain(
                springDataLinkRepository.getReferenceById(id));
    }

    @Override
    public Link addLink(final Link link) {
        return linkMapper.mapToDomain(
                springDataLinkRepository.save(
                        linkMapper.mapToEntity(link)
                ));
    }

    @Override
    public Link updateLink(final Link link) {
        return linkMapper.mapToDomain(
                springDataLinkRepository.save(
                        linkMapper.mapToEntity(link)
                ));
    }

    @Override
    public void deleteLink(Long id) {
        springDataLinkRepository.deleteById(id);
    }
}
