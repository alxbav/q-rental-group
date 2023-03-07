package ee.qrental.car.application.port.out;


import ee.qrental.car.domain.Car;
import ee.qrental.common.core.api.application.port.LoadPort;

public interface CarLoadPort
        extends LoadPort<Car> {
    Car loadByRegNumber(final String regNumber);
}