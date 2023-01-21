package ee.qrental.driverpotential.application.port.out;

import ee.qrental.driverpotential.domain.DriverPotential;

import java.util.List;

public interface LoadDriverPotentialPort {
    List<DriverPotential> loadAllPotentialDrivers();
}
