package ee.qrental.driver.application.service;

import ee.qrental.driver.application.port.out.AddDriverPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverApplicationConfig {

    @Bean
    public DriverService getDriverService(
            final AddDriverPort addDriverPort){
        return new DriverService(addDriverPort);
    }
}
