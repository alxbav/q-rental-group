package ee.qrental.driver.adapter.out.persistance.adapter;

import ee.qrental.driver.adapter.out.persistance.mapper.DriverMapper;
import ee.qrental.driver.adapter.out.persistance.repositories.SpringDataDriverRepository;
import ee.qrental.driver.application.port.out.DriverAddPort;
import ee.qrental.driver.application.port.out.DriverDeletePort;
import ee.qrental.driver.application.port.out.DriverUpdatePort;
import ee.qrental.driver.domain.Driver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor


public class DriverPersistenceAdapter implements
        DriverAddPort,
        DriverUpdatePort,
        DriverDeletePort {

    private final SpringDataDriverRepository springRepository;
    private final DriverMapper mapper;

    @Override
    public Driver add(final Driver driver) {
        return mapper.mapToDomain(
                springRepository.save(
                        mapper.mapToEntity(driver)
                ));
    }

    @Override
    public Driver update(final Driver driver) {
        return mapper.mapToDomain(
                springRepository.save(
                        mapper.mapToEntity(driver)
                ));
    }

    @Override
    public void delete(Long id) {
        springRepository.deleteById(id);
    }
}
