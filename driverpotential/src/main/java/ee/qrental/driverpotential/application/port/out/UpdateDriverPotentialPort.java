package ee.qrental.driverpotential.application.port.out;

import ee.qrental.driverpotential.domain.DriverPotential;

public interface UpdateDriverPotentialPort {
    DriverPotential updateDriverPotential(DriverPotential driverPotential);
}
