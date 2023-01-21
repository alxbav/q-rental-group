package ee.qrental.driverpotential.application.service;

import ee.qrental.driverpotential.application.port.out.AddDriverPotentialPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverPotentialApplicationConfig {

    @Bean
    public DriverPotentialService getDriverPotentialService(
            final AddDriverPotentialPort addDriverPotentialPort){
        return new DriverPotentialService(addDriverPotentialPort);
    }
}
