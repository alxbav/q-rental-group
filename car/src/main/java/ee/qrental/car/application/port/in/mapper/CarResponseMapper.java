package ee.qrental.car.application.port.in.mapper;

import ee.qrental.car.application.port.in.response.CarResponse;
import ee.qrental.car.domain.Car;
import ee.qrental.common.core.api.application.mapper.ResponseMapper;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class CarResponseMapper
        implements ResponseMapper<CarResponse, Car> {

    @Override
    public CarResponse toResponse(final Car domain) {
        final var response = new CarResponse();
        response.setId(domain.getId());
        response.setRegNumber(domain.getRegNumber());
        response.setReleaseDate(domain.getReleaseDate());
        response.setManufacturer(domain.getManufacturer());
        response.setModel(domain.getModel());
        response.setGearType(domain.getGearType());
        response.setFuelType(domain.getFuelType());
        response.setComment(domain.getComment());

        return response;
    }

    @Override
    public String toObjectInfo(Car domain) {
        return format(" %s , %s -  %s ",
                domain.getRegNumber(),
                domain.getManufacturer(),
                domain.getModel());
    }
}