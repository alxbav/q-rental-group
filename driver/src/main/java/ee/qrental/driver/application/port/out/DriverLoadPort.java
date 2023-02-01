package ee.qrental.driver.application.port.out;

import ee.qrental.driver.domain.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverLoadPort {
    List<Driver> loadAllDrivers();
    Optional<Driver> loadDriverByPhone(String phone);
    Driver loadDriverById(Long id);
}
