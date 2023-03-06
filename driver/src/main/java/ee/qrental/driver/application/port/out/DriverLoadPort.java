package ee.qrental.driver.application.port.out;

import ee.qrental.driver.domain.Driver;

import java.util.List;

public interface DriverLoadPort {
    List<Driver> loadAll();

    Driver loadById(Long id);

}
