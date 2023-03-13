package ee.qrental.transaction.adapter.out.persistance.adapter;

import ee.qrental.transaction.adapter.out.persistance.mapper.FirmMapper;
import ee.qrental.transaction.adapter.out.persistance.repostories.SpringDataFirmRepository;
import ee.qrental.transaction.application.port.out.FirmLoadPort;
import ee.qrental.transaction.domain.Firm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class FirmLoadAdapter
        implements FirmLoadPort {

    private final SpringDataFirmRepository springRepository;
    private final FirmMapper mapper;

    @Override
    public List<Firm> loadAll() {
        return springRepository.findAll()
                .stream()
                .map(mapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public Firm loadById(Long id) {
        return mapper.mapToDomain(
                springRepository.getReferenceById(id));
    }

    @Override
    public Firm loadByName(String name) {
        return mapper.mapToDomain(
                springRepository.findByName(name));
    }
}
