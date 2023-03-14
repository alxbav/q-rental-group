package ee.qrental.callsignlink.adapter.out.persistance.adapter.callsignlink;

import ee.qrental.callsignlink.adapter.out.persistance.mapper.CallSignLinkMapper;
import ee.qrental.callsignlink.adapter.out.persistance.repository.CallSignLinkSpringDataRepository;
import ee.qrental.callsignlink.application.port.out.callsignlink.CallSignLinkLoadPort;
import ee.qrental.callsignlink.domain.CallSignLink;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component

@AllArgsConstructor
public class CallSignLinkLoadAdapter implements CallSignLinkLoadPort {

    private final CallSignLinkSpringDataRepository springRepository;
    private final CallSignLinkMapper mapper;

    @Override
    public CallSignLink loadById(final Long id) {
        return mapper.mapToDomain(springRepository.getReferenceById(id));
    }

    @Override
    public List<CallSignLink> loadAll() {
        return springRepository.findAll()
                .stream()
                .map(mapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public List<CallSignLink> loadActiveCallSignLinks() {
        return springRepository.findAllByDateEndIsNull()
                .stream()
                .map(mapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public CallSignLink loadByDriverId(final Long driverId) {
        return mapper.mapToDomain(springRepository.findFirstByDriverId(driverId));
    }
}
