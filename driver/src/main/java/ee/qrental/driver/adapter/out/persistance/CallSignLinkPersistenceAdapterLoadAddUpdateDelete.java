package ee.qrental.driver.adapter.out.persistance;


import ee.qrental.driver.application.port.out.CallSignLinkAddPort;
import ee.qrental.driver.application.port.out.CallSignLinkDeletePort;
import ee.qrental.driver.application.port.out.CallSignLinkLoadPort;
import ee.qrental.driver.application.port.out.CallSignLinkUpdatePort;
import ee.qrental.driver.domain.CallSignLink;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class CallSignLinkPersistenceAdapterLoadAddUpdateDelete implements
        CallSignLinkLoadPort,
        CallSignLinkAddPort ,
        CallSignLinkUpdatePort,
        CallSignLinkDeletePort {


    private final SpringDataCallSignLinkRepository springDataCallSignLinkRepository;

    private final CallSignLinkMapper callSignLinkMapper;

    @Override
    public List<CallSignLink> loadAllCallSignLinks() {
        return springDataCallSignLinkRepository.findAll()
                .stream()
                .map(callSignLinkMapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public CallSignLink loadCallSignLinkById(Long id) {
        return callSignLinkMapper.mapToDomain(
                springDataCallSignLinkRepository.getReferenceById(id));
    }

    @Override
    public CallSignLink addCallSignLink(final CallSignLink callSignLink) {
        return callSignLinkMapper.mapToDomain(
                springDataCallSignLinkRepository.save(
                        callSignLinkMapper.mapToEntity(callSignLink)
                ));
    }



    @Override
    public CallSignLink updateCallSignLink(final CallSignLink callSignLink) {
        return callSignLinkMapper.mapToDomain(
                springDataCallSignLinkRepository.save(
                        callSignLinkMapper.mapToEntity(callSignLink)
                ));
    }

    @Override
    public void deleteCallSignLink(Long id) { springDataCallSignLinkRepository.deleteById(id);

    }
}
