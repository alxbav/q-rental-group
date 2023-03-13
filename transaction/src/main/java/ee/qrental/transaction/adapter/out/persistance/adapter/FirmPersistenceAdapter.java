package ee.qrental.transaction.adapter.out.persistance.adapter;

import ee.qrental.transaction.adapter.out.persistance.mapper.FirmMapper;
import ee.qrental.transaction.adapter.out.persistance.repostories.SpringDataFirmRepository;
import ee.qrental.transaction.application.port.out.FirmAddPort;
import ee.qrental.transaction.application.port.out.FirmDeletePort;
import ee.qrental.transaction.application.port.out.FirmUpdatePort;
import ee.qrental.transaction.domain.Firm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FirmPersistenceAdapter
        implements FirmAddPort,
        FirmUpdatePort,
        FirmDeletePort {

    private final SpringDataFirmRepository springRepository;
    private final FirmMapper mapper;

    @Override
    public Firm add(final Firm firm) {
        return mapper.mapToDomain(
                springRepository.save(
                        mapper.mapToEntity(firm)
                ));
    }

    @Override
    public Firm update(final Firm firm) {
        return mapper.mapToDomain(
                springRepository.save(
                        mapper.mapToEntity(firm)
                ));
    }

    @Override
    public void delete(Long id) {
        springRepository.deleteById(id);
    }
}
