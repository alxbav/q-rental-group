package ee.qrental.driverpotential.application.service;

import ee.qrental.driverpotential.application.port.out.AddDriverPotentialPort;
import ee.qrental.driverpotential.application.port.out.LoadDriverPotentialPort;
import ee.qrental.driverpotential.application.port.out.UpdateDriverPotentialPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverPotentialApplicationConfig {

    @Bean
    public DriverPotentialService getDriverPotentialService(
            final AddDriverPotentialPort addDriverPotentialPort,
            final UpdateDriverPotentialPort updateDriverPotentialPort,
            final LoadDriverPotentialPort loadDriverPotentialPort){
        return new DriverPotentialService(addDriverPotentialPort,
                updateDriverPotentialPort,
                loadDriverPotentialPort);
    }
}
