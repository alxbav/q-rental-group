package ee.qrental.driverpotential.application.service;

import ee.qrental.driverpotential.application.port.out.DriverPotentialAddPort;
import ee.qrental.driverpotential.application.port.out.DriverPotentialDeletePort;
import ee.qrental.driverpotential.application.port.out.DriverPotentialLoadPort;
import ee.qrental.driverpotential.application.port.out.DriverPotentialUpdatePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverPotentialApplicationConfig {

    @Bean
    public DriverPotentialService getDriverPotentialService(
            final DriverPotentialAddPort driverPotentialAddPort,
            final DriverPotentialUpdatePort driverPotentialUpdatePort,
            final DriverPotentialLoadPort driverPotentialLoadPort,
            final DriverPotentialDeletePort driverPotentialDeletePort){
        return new DriverPotentialService(driverPotentialAddPort,
                driverPotentialUpdatePort,
                driverPotentialLoadPort,
                driverPotentialDeletePort);
    }
}
