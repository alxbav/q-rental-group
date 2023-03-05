package ee.qrental.callsignlink.adapter.out.persistance.adapter.callsignlink;

import ee.qrental.callsignlink.adapter.out.persistance.mapper.CallSignLinkMapper;
import ee.qrental.callsignlink.adapter.out.persistance.repository.CallSignLinkSpringDataRepository;
import ee.qrental.callsignlink.application.port.out.callsignlink.CallSignLinkAddPort;
import ee.qrental.callsignlink.application.port.out.callsignlink.CallSignLinkDeletePort;
import ee.qrental.callsignlink.application.port.out.callsignlink.CallSignLinkUpdatePort;
import ee.qrental.callsignlink.domain.CallSignLink;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CallSignLinkPersistenceAdapter implements
        CallSignLinkAddPort,
        CallSignLinkUpdatePort,
        CallSignLinkDeletePort {

    private final CallSignLinkSpringDataRepository springRepository;
    private final CallSignLinkMapper mapper;

    @Override
    public CallSignLink add(final CallSignLink domain) {
        return mapper.mapToDomain(
                springRepository.save(
                        mapper.mapToEntity(domain)
                ));
    }

    @Override
    public CallSignLink update(final CallSignLink domain) {
        return mapper.mapToDomain(
                springRepository.save(
                        mapper.mapToEntity(domain)
                ));
    }

    @Override
    public void delete(final Long id) {
        springRepository.deleteById(id);
    }
}
