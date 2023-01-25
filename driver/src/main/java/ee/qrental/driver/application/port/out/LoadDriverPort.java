package ee.qrental.driver.application.port.out;

import ee.qrental.driver.domain.Driver;

import java.util.List;

public interface LoadDriverPort {
    List<Driver> loadAllDrivers();
}
