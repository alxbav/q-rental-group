package ee.qrental.driver.adapter.out.persistance;

import ee.qrental.driver.application.port.out.AddDriverPort;
import ee.qrental.driver.application.port.out.LoadDriverPort;
import ee.qrental.driver.domain.Driver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class DriverPersistenceAdapter implements
        LoadDriverPort,
        AddDriverPort {

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
    public Driver addDriver(final Driver driver) {
        final var entity = springDataDriverRepository.save(
                driverMapper.mapToEntity(driver)
        );
        return driverMapper.mapToDomain(entity);
    }
}
