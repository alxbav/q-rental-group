package ee.qrental.car.application.port.out;

import ee.qrental.car.domain.Car;

public interface CarUpdatePort {
    Car updateCar(Car car);
}
