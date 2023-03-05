package ee.qrental.callsignlink.adapter.out.persistance.adapter.callsign;

import ee.qrental.callsignlink.adapter.out.persistance.mapper.CallSignMapper;
import ee.qrental.callsignlink.adapter.out.persistance.repository.CallSignSpringDataRepository;
import ee.qrental.callsignlink.application.port.out.callsign.CallSignAddPort;
import ee.qrental.callsignlink.application.port.out.callsign.CallSignDeletePort;
import ee.qrental.callsignlink.application.port.out.callsign.CallSignUpdatePort;
import ee.qrental.callsignlink.domain.CallSign;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CallSignPersistenceAdapter implements
        CallSignAddPort,
        CallSignUpdatePort,
        CallSignDeletePort {

    private final CallSignSpringDataRepository springRepository;
    private final CallSignMapper mapper;

    @Override
    public CallSign add(final CallSign transactionType) {
        return mapper.mapToDomain(
                springRepository.save(
                        mapper.mapToEntity(transactionType)
                ));
    }

    @Override
    public CallSign update(final CallSign transactionType) {
        return mapper.mapToDomain(
                springRepository.save(
                        mapper.mapToEntity(transactionType)
                ));
    }

    @Override
    public void delete(Long id) {
        springRepository.deleteById(id);
    }
}
