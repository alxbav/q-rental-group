package ee.qrental.driverpotential.application.port.out;

import ee.qrental.driverpotential.domain.DriverPotential;

import java.util.List;
import java.util.Optional;

public interface DriverPotentialLoadPort {
    List<DriverPotential> loadAllPotentialDrivers();
    Optional<DriverPotential> loadPotentialDriverByPhone(String phone);
    DriverPotential loadPotentialDriverById(Long id);
}
