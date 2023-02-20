package ee.qrental.transaction.adapter.out.persistance;

import ee.qrental.transaction.adapter.out.persistance.mapper.FirmMapper;
import ee.qrental.transaction.adapter.out.persistance.repostories.SpringDataFirmRepository;
import ee.qrental.transaction.application.port.out.*;
import ee.qrental.transaction.domain.Firm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class FirmPersistenceAdapterLoadAddUpdateDelete implements
        FirmLoadPort,
        FirmAddPort,
        FirmUpdatePort,
        FirmDeletePort {

    private final SpringDataFirmRepository springDataFirmRepository;
    private final FirmMapper firmMapper;

    @Override
    public List<Firm> loadAll() {
        return springDataFirmRepository.findAll()
                .stream()
                .map(firmMapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public Firm loadById(Long id) {
        return firmMapper.mapToDomain(
                springDataFirmRepository.getReferenceById(id));
    }

    @Override
    public Firm add(final Firm firm) {
        return firmMapper.mapToDomain(
                springDataFirmRepository.save(
                        firmMapper.mapToEntity(firm)
                ));
    }

    @Override
    public Firm update(final Firm firm) {
        return firmMapper.mapToDomain(
                springDataFirmRepository.save(
                        firmMapper.mapToEntity(firm)
                ));
    }

    @Override
    public void delete(Long id) {
        springDataFirmRepository.deleteById(id);
    }
}
