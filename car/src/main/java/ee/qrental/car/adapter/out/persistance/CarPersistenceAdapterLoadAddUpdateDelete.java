package ee.qrental.car.adapter.out.persistance;

import ee.qrental.car.application.port.out.CarAddPort;
import ee.qrental.car.application.port.out.CarDeletePort;
import ee.qrental.car.application.port.out.CarLoadPort;
import ee.qrental.car.application.port.out.CarUpdatePort;
import ee.qrental.car.domain.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class CarPersistenceAdapterLoadAddUpdateDelete implements
        CarLoadPort,
        CarAddPort,
        CarUpdatePort,
        CarDeletePort {

    private final SpringDataCarRepository springDataCarRepository;
    private final CarMapper carMapper;

    @Override
    public List<Car> loadAllCars() {
        return springDataCarRepository.findAll()
                .stream()
                .map(carMapper::mapToDomain)
                .collect(toList());
    }



    @Override
    public Car loadCarById(Long id) {
        return carMapper.mapToDomain(
                springDataCarRepository.getReferenceById(id));
    }

    @Override
    public Car addCar(final Car car) {
        return carMapper.mapToDomain(
                springDataCarRepository.save(
                        carMapper.mapToEntity(car)
                ));
    }

    @Override
    public Car updateCar(final Car car) {
        return carMapper.mapToDomain(
                springDataCarRepository.save(
                        carMapper.mapToEntity(car)
                ));
    }

    @Override
    public void deleteCar(Long id) {
        springDataCarRepository.deleteById(id);
    }
}
