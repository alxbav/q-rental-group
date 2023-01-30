package ee.qrental.driverpotential.adapter.out.persistance;

import ee.qrental.driverpotential.application.port.out.DriverPotentialAddPort;
import ee.qrental.driverpotential.application.port.out.DriverPotentialDeletePort;
import ee.qrental.driverpotential.application.port.out.DriverPotentialLoadPort;
import ee.qrental.driverpotential.application.port.out.DriverPotentialUpdatePort;
import ee.qrental.driverpotential.domain.DriverPotential;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class DriverPotentialPersistenceAdapterLoadAddUpdateDelete implements
        DriverPotentialLoadPort,
        DriverPotentialAddPort,
        DriverPotentialUpdatePort,
        DriverPotentialDeletePort {

    private final SpringDataDriverPotentialRepository springDataDriverPotentialRepository;
    private final DriverPotentialMapper driverPotentialMapper;

    @Override
    public List<DriverPotential> loadAllPotentialDrivers() {
        return springDataDriverPotentialRepository.findAll()
                .stream()
                .map(driverPotentialMapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public Optional<DriverPotential> loadPotentialDriverByPhone(String phone) {
        return springDataDriverPotentialRepository
                .getDriverPotentialJpaEntityByPhone(phone)
                .map(entity -> driverPotentialMapper.mapToDomain(entity));
    }

    @Override
    public DriverPotential loadPotentialDriverById(Long id) {
        return driverPotentialMapper.mapToDomain(
                springDataDriverPotentialRepository.getReferenceById(id));
    }

    @Override
    public DriverPotential addDriverPotential(final DriverPotential driverPotential) {
        return driverPotentialMapper.mapToDomain(
                springDataDriverPotentialRepository.save(
                        driverPotentialMapper.mapToEntity(driverPotential)
                ));
    }

    @Override
    public DriverPotential updateDriverPotential(final DriverPotential driverPotential) {
        return driverPotentialMapper.mapToDomain(
                springDataDriverPotentialRepository.save(
                        driverPotentialMapper.mapToEntity(driverPotential)
                ));
    }

    @Override
    public void deleteDriverPotential(Long id) {
        springDataDriverPotentialRepository.deleteById(id);
    }
}
