package ee.qrental.car.application.port.in.mapper;

import ee.qrental.car.application.port.in.request.CarAddRequest;
import ee.qrental.car.domain.Car;
import ee.qrental.common.core.api.application.mapper.AddRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class CarAddRequestMapper
        implements AddRequestMapper<CarAddRequest, Car> {

    @Override
    public Car toDomain(CarAddRequest request) {
        final var domain = new Car();
        domain.setId(null);
        domain.setComment(request.getComment());

        return domain;
    }
}
