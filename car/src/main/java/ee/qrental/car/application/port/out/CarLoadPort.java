package ee.qrental.car.application.port.out;

import ee.qrental.car.domain.Car;

import java.util.List;
import java.util.Optional;

public interface CarLoadPort {
    List<Car> loadAllCars();

    Car loadCarById(Long id);
}
