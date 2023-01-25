package ee.qrental.driver.application.port.out;

import ee.qrental.driver.domain.Driver;

public interface AddDriverPort {
    Driver addDriver(Driver driver);
}
