package ee.qrental.link.adapter.out.persistance.adapter;

import ee.qrental.link.adapter.out.persistance.mapper.LinkMapper;
import ee.qrental.link.adapter.out.persistance.repository.SpringDataLinkRepository;
import ee.qrental.link.application.port.out.LinkAddPort;
import ee.qrental.link.application.port.out.LinkDeletePort;
import ee.qrental.link.application.port.out.LinkUpdatePort;
import ee.qrental.link.domain.Link;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LinkPersistenceAdapter
        implements LinkAddPort,
        LinkUpdatePort,
        LinkDeletePort {

    private final SpringDataLinkRepository springDataLinkRepository;
    private final LinkMapper linkMapper;

    @Override
    public Link add(final Link link) {
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
    public void delete(Long id) {
        springDataLinkRepository.deleteById(id);
    }
}
