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

    private final SpringDataCarRepository springRepository;
    private final CarMapper mapper;

    @Override
    public List<Car> loadAll() {
        return springRepository.findAll()
                .stream()
                .map(mapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public Car loadById(Long id) {
        return mapper.mapToDomain(
                springRepository.getReferenceById(id));
    }

    @Override
    public Car loadByRegNumber(final String regNumber) {
        return mapper.mapToDomain(
                springRepository.findByRegNumber(regNumber));
    }
}
