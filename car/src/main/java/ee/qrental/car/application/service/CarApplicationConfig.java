package ee.qrental.car.application.service;

import ee.qrental.car.application.port.out.CarAddPort;
import ee.qrental.car.application.port.out.CarDeletePort;
import ee.qrental.car.application.port.out.CarLoadPort;
import ee.qrental.car.application.port.out.CarUpdatePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarApplicationConfig {

    @Bean
    public CarService getCarService(
            final CarAddPort carAddPort,
            final CarUpdatePort carUpdatePort,
            final CarLoadPort carLoadPort,
            final CarDeletePort carDeletePort){
        return new CarService(carAddPort,
                carUpdatePort,
                carLoadPort,
                carDeletePort);
    }
}
