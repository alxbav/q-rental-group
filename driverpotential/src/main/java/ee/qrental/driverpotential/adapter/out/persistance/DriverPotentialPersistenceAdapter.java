package ee.qrental.driverpotential.adapter.out.persistance;

import ee.qrental.driverpotential.application.port.out.AddDriverPotentialPort;
import ee.qrental.driverpotential.application.port.out.LoadDriverPotentialPort;
import ee.qrental.driverpotential.domain.DriverPotential;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class DriverPotentialPersistenceAdapter implements
        LoadDriverPotentialPort,
        AddDriverPotentialPort {

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
    public DriverPotential addDriverPotential(final DriverPotential driverPotential) {
        final var entity = springDataDriverPotentialRepository.save(
                driverPotentialMapper.mapToEntity(driverPotential)
        );
        return driverPotentialMapper.mapToDomain(entity);
    }
}
