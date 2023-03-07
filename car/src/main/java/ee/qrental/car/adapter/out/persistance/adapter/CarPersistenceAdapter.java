package ee.qrental.car.adapter.out.persistance.adapter;

import ee.qrental.car.adapter.out.persistance.mapper.CarMapper;
import ee.qrental.car.adapter.out.persistance.repository.SpringDataCarRepository;
import ee.qrental.car.application.port.out.CarAddPort;
import ee.qrental.car.application.port.out.CarDeletePort;
import ee.qrental.car.application.port.out.CarUpdatePort;
import ee.qrental.car.domain.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CarPersistenceAdapter
        implements CarAddPort,
        CarUpdatePort,
        CarDeletePort {

    private final SpringDataCarRepository springDataCarRepository;
    private final CarMapper carMapper;

    @Override
    public Car add(final Car car) {
        return carMapper.mapToDomain(
                springDataCarRepository.save(
                        carMapper.mapToEntity(car)
                ));
    }

    @Override
    public Car update(final Car car) {
        return carMapper.mapToDomain(
                springDataCarRepository.save(
                        carMapper.mapToEntity(car)
                ));
    }

    @Override
    public void delete(Long id) {
        springDataCarRepository.deleteById(id);
    }
}
