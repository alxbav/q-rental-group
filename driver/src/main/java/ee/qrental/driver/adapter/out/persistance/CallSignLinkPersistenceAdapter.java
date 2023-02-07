package ee.qrental.driver.adapter.out.persistance;


import ee.qrental.driver.application.port.out.CallSignLinkAddPort;
import ee.qrental.driver.application.port.out.CallSignLinkLoadPort;
import ee.qrental.driver.domain.CallSignLink;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class CallSignLinkPersistenceAdapter implements
        CallSignLinkLoadPort,
        CallSignLinkAddPort {
    private final SpringDataCallSignLinkRepository springDataCallSignLinkRepository;
    private final SpringDataDriverRepository springDataDriverRepository;

    private final CallSignLinkMapper callSignLinkMapper;

    @Override
    public List<CallSignLink> loadAllCallSignLinks() {
        return springDataCallSignLinkRepository.findAll()
                .stream()
                .map(callSignLinkMapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public CallSignLink addCallSignLink(CallSignLink callSignLink) {
        final var jpaDriver = springDataDriverRepository.getReferenceById(callSignLink.getDriverId());
        final var jpaEntity = callSignLinkMapper.mapToEntity(callSignLink);
        jpaEntity.setDriver(jpaDriver);
        return callSignLinkMapper.mapToDomain(
                springDataCallSignLinkRepository.save(jpaEntity));
    }
}
