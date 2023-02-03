package ee.qrental.car.application.service;

import ee.qrental.car.application.port.in.command.CarAddCommand;
import ee.qrental.car.application.port.in.command.CarUpdateCommand;
import ee.qrental.car.application.port.in.usecase.CarAddUseCase;
import ee.qrental.car.application.port.in.usecase.CarDeleteUseCase;
import ee.qrental.car.application.port.in.usecase.CarUpdateUseCase;
import ee.qrental.car.application.port.out.CarAddPort;
import ee.qrental.car.application.port.out.CarDeletePort;
import ee.qrental.car.application.port.out.CarLoadPort;
import ee.qrental.car.application.port.out.CarUpdatePort;
import ee.qrental.car.domain.Car;
import lombok.AllArgsConstructor;

import static java.lang.Boolean.TRUE;

@AllArgsConstructor
class CarService implements
        CarAddUseCase,
        CarUpdateUseCase,
        CarDeleteUseCase {

    private final CarAddPort carAddPort;
    private final CarUpdatePort carUpdatePort;
    private final CarLoadPort carLoadPort;
    private final CarDeletePort carDeletePort;

    @Override
    public void add(final CarAddCommand command) {
        final var carDomain = new Car(
                null,
                command.getActive(),
                command.getQRent(),
                command.getRegNumber(),
                command.getVin(),
                command.getReleaseDate(),
                command.getManufacturer(),
                command.getModel(),
                command.getAppropriation(),
                command.getElegance(),
                command.getGearType(),
                command.getFuelType(),
                command.getLpg(),
                command.getDateInstallLpg(),
                command.getInsuranceFirm(),
                command.getInsuranceDateStart(),
                command.getInsuranceDateEnd(),
                command.getSCard(),
                command.getKey2(),
                command.getGps(),
                command.getTechnicalInspectionEnd(),
                command.getGasInspectionEnd(),
                command.getComment());
        carAddPort.addCar(carDomain);
    }

    @Override
    public void update(final CarUpdateCommand command) {
        final Long carId = command.getId();
        final Car domain = carLoadPort.loadCarById(carId);
        if (domain == null) {
            throw new RuntimeException("Update of Car failed. No Car with id = " + carId);
        }
        updateDomain(command, domain);
        carUpdatePort.updateCar(domain);
    }

    private void updateDomain(
            final CarUpdateCommand command,
            final Car toUpdate) {
        toUpdate.setActive(command.getActive());
        toUpdate.setQRent(command.getQRent());
        toUpdate.setRegNumber(command.getRegNumber());
        toUpdate.setVin(command.getVin());
        toUpdate.setReleaseDate(command.getReleaseDate());
        toUpdate.setManufacturer(command.getManufacturer());
        toUpdate.setModel(command.getModel());
        toUpdate.setAppropriation(command.getAppropriation());
        toUpdate.setElegance(command.getElegance());
        toUpdate.setGearType(command.getGearType());
        toUpdate.setFuelType(command.getFuelType());
        toUpdate.setLpg(command.getLpg());
        toUpdate.setDateInstallLpg(command.getDateInstallLpg());
        toUpdate.setInsuranceFirm(command.getInsuranceFirm());
        toUpdate.setInsuranceDateStart(command.getInsuranceDateStart());
        toUpdate.setInsuranceDateEnd(command.getInsuranceDateEnd());
        toUpdate.setSCard(command.getSCard());
        toUpdate.setKey2(command.getKey2());
        toUpdate.setGps(command.getGps());
        toUpdate.setTechnicalInspectionEnd(command.getTechnicalInspectionEnd());
        toUpdate.setGasInspectionEnd(command.getGasInspectionEnd());
        toUpdate.setComment(command.getComment());
    }

    @Override
    public void delete(Long carId) {
        carDeletePort.deleteCar(carId);
    }
}
