package ee.qrental.driver.application.port.out;

import ee.qrental.driver.domain.Driver;

public interface DriverUpdatePort {
    Driver updateDriver(Driver driver);
}
