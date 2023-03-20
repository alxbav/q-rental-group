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

    private final SpringDataCarRepository springRepository;
    private final CarMapper mapper;

    @Override
    public Car add(final Car car) {
        return mapper.mapToDomain(
                springRepository.save(
                        mapper.mapToEntity(car)
                ));
    }

    @Override
    public Car update(final Car car) {
        return mapper.mapToDomain(
                springRepository.save(
                        mapper.mapToEntity(car)
                ));
    }

    @Override
    public void delete(Long id) {
        springRepository.deleteById(id);
    }
}
