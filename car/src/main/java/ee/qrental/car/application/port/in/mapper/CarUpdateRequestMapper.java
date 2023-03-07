package ee.qrental.car.application.port.in.mapper;

import ee.qrental.car.application.port.in.request.CarUpdateRequest;
import ee.qrental.car.domain.Car;
import ee.qrental.common.core.api.application.mapper.UpdateRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class CarUpdateRequestMapper
        implements UpdateRequestMapper<CarUpdateRequest, Car> {

    @Override
    public Car toDomain(final CarUpdateRequest request) {
        final var domain = new Car();
        domain.setId(request.getId());
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
        domain.setDateEndLpg(request.getDateEndLpg());
        domain.setInsuranceFirm(request.getInsuranceFirm());
        domain.setInsuranceDateStart(request.getInsuranceDateStart());
        domain.setInsuranceDateEnd(request.getInsuranceDateEnd());
        domain.setSCard(request.getSCard());
        domain.setKey2(request.getKey2());
        domain.setGps(request.getGps());
        domain.setTechnicalInspectionEnd(request.getTechnicalInspectionEnd());
        domain.setGasInspectionEnd(request.getGasInspectionEnd());
        domain.setComment(request.getComment());

        return domain;
    }

    @Override
    public CarUpdateRequest toRequest(final Car domain) {
        final var request = new CarUpdateRequest();
        request.setId(domain.getId());
        request.setActive(domain.getActive());
        request.setQRent(domain.getQRent());
        request.setRegNumber(domain.getRegNumber());
        request.setVin(domain.getVin());
        request.setReleaseDate(domain.getReleaseDate());
        request.setManufacturer(domain.getManufacturer());
        request.setModel(domain.getModel());
        request.setAppropriation(domain.getAppropriation());
        request.setElegance(domain.getElegance());
        request.setGearType(domain.getGearType());
        request.setFuelType(domain.getFuelType());
        request.setLpg(domain.getLpg());
        request.setDateInstallLpg(domain.getDateInstallLpg());
        request.setDateEndLpg(domain.getDateEndLpg());
        request.setInsuranceFirm(domain.getInsuranceFirm());
        request.setInsuranceDateStart(domain.getInsuranceDateStart());
        request.setInsuranceDateEnd(domain.getInsuranceDateEnd());
        request.setSCard(domain.getSCard());
        request.setKey2(domain.getKey2());
        request.setGps(domain.getGps());
        request.setTechnicalInspectionEnd(domain.getTechnicalInspectionEnd());
        request.setGasInspectionEnd(domain.getGasInspectionEnd());
        request.setComment(domain.getComment());

        return request;
    }
}
