package ee.qrental.callsignlink.adapter.out.persistance.adapter.callsign;

import ee.qrental.callsignlink.adapter.out.persistance.mapper.CallSignMapper;
import ee.qrental.callsignlink.adapter.out.persistance.repository.CallSignSpringDataRepository;
import ee.qrental.callsignlink.application.port.out.callsign.CallSignLoadPort;
import ee.qrental.callsignlink.domain.CallSign;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class CallSignLoadAdapter implements CallSignLoadPort {

    private final CallSignSpringDataRepository springRepository;
    private final CallSignMapper mapper;

    @Override
    public List<CallSign> loadAll() {
        return springRepository.findAll()
                .stream()
                .map(mapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public CallSign loadById(final Long id) {
        return mapper.mapToDomain(
                springRepository.getReferenceById(id));
    }

    @Override
    public CallSign loadByCallSign(final Integer callSign) {
        return mapper.mapToDomain(
                springRepository.findByCallSign(callSign)
        );
    }
}
