package ee.qrental.driver.adapter.out.persistance.adapter;

import ee.qrental.driver.adapter.out.persistance.mapper.DriverMapper;
import ee.qrental.driver.adapter.out.persistance.repositories.SpringDataDriverRepository;
import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.driver.application.port.out.DriverAddPort;
import ee.qrental.driver.application.port.out.DriverDeletePort;
import ee.qrental.driver.application.port.out.DriverUpdatePort;
import ee.qrental.driver.domain.Driver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class DriverLoadAdapter
        implements DriverLoadPort {

    private final SpringDataDriverRepository springRepository;
    private final DriverMapper mapper;

    @Override
    public List<Driver> loadAll() {
        return springRepository.findAll()
                .stream()
                .map(mapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public Driver loadById(Long id) {
        return mapper.mapToDomain(
                springRepository.getReferenceById(id));
    }
}
