package ee.qrental.car.adapter.out.persistance.adapter;

import ee.qrental.car.adapter.out.persistance.mapper.CarMapper;
import ee.qrental.car.adapter.out.persistance.repository.SpringDataCarRepository;
import ee.qrental.car.application.port.out.CarLoadPort;
import ee.qrental.car.domain.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component

@AllArgsConstructor
public class CarLoadAdapter
        implements CarLoadPort {

    private final SpringDataCarRepository springDataCarRepository;
    private final CarMapper carMapper;

    @Override
    public List<Car> loadAll() {
        return springDataCarRepository.findAll()
                .stream()
                .map(carMapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public Car loadById(Long id) {
        return carMapper.mapToDomain(
                springDataCarRepository.getReferenceById(id));
    }

    @Override
    public Car loadByRegNumber(final String regNumber) {
        return carMapper.mapToDomain(
                springDataCarRepository.findByRegNumber(regNumber));
    }
}
