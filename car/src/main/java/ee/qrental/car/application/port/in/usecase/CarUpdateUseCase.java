package ee.qrental.car.application.port.in.usecase;

import ee.qrental.car.application.port.in.command.CarUpdateCommand;

public interface CarUpdateUseCase {
    void update(CarUpdateCommand car);
}
