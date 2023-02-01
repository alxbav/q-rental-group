package ee.qrental.driver.adapter.out.persistance;

import ee.qrental.driver.application.port.out.DriverAddPort;
import ee.qrental.driver.application.port.out.DriverDeletePort;
import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.driver.application.port.out.DriverUpdatePort;
import ee.qrental.driver.domain.Driver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class DriverPersistenceAdapterLoadAddUpdateDelete implements
        DriverLoadPort,
        DriverAddPort,
        DriverUpdatePort,
        DriverDeletePort {

    private final SpringDataDriverRepository springDataDriverRepository;
    private final DriverMapper driverMapper;

    @Override
    public List<Driver> loadAllDrivers() {
        return springDataDriverRepository.findAll()
                .stream()
                .map(driverMapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public Optional<Driver> loadDriverByPhone(String phone) {
        return springDataDriverRepository
                .getDriverJpaEntityByPhone(phone)
                .map(entity -> driverMapper.mapToDomain(entity));
    }

    @Override
    public Driver loadDriverById(Long id) {
        return driverMapper.mapToDomain(
                springDataDriverRepository.getReferenceById(id));
    }

    @Override
    public Driver addDriver(final Driver driver) {
        return driverMapper.mapToDomain(
                springDataDriverRepository.save(
                        driverMapper.mapToEntity(driver)
                ));
    }

    @Override
    public Driver updateDriver(final Driver driver) {
        return driverMapper.mapToDomain(
                springDataDriverRepository.save(
                        driverMapper.mapToEntity(driver)
                ));
    }

    @Override
    public void deleteDriver(Long id) {
        springDataDriverRepository.deleteById(id);
    }
}
