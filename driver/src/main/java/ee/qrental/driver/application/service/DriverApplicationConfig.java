package ee.qrental.driver.application.service;

import ee.qrental.driver.application.port.out.DriverAddPort;
import ee.qrental.driver.application.port.out.DriverDeletePort;
import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.driver.application.port.out.DriverUpdatePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverApplicationConfig {

    @Bean
    public DriverService getDriverService(
            final DriverAddPort driverAddPort,
            final DriverUpdatePort driverUpdatePort,
            final DriverLoadPort driverLoadPort,
            final DriverDeletePort driverDeletePort){
        return new DriverService(driverAddPort,
                driverUpdatePort,
                driverLoadPort,
                driverDeletePort);
    }
}