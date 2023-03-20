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
        domain.setActive(request.getActive());
        domain.setQRent(request.getQRent());
        domain.setRegNumber(request.getRegNumber());
        domain.setVin(request.getVin());
        domain.setReleaseDate(request.getReleaseDate());
        domain.setManufacturer(request.getManufacturer());
        domain.setModel(request.getModel());
        domain.setAppropriation(request.getAppropriation());
        domain.setElegance(request.getElegance());
        domain.setGearType(request.getGearType());
        domain.setFuelType(request.getFuelType());
        domain.setLpg(request.getLpg());
        domain.setDateInstallLpg(request.getDateInstallLpg());
        domain.setInsuranceFirm(request.getInsuranceFirm());
        domain.setInsuranceDateStart(request.getInsuranceDateStart());
        domain.setInsuranceDateEnd(request.getInsuranceDateEnd());
        domain.setSCard(request.getSCard());
        domain.setKey2(request.getKey2());
        domain.setGps(request.getGps());
        domain.setTechnicalInspectionEnd(request.getTechnicalInspectionEnd());
        domain.setGasInspectionEnd(request.getGasInspectionEnd());
        domain.setComment(request.getComment());
        domain.setDateEndLpg(request.getDateEndLpg());

        return domain;
    }
}
