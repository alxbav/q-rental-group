package ee.qrental.car.application.port.in.usecase;

import ee.qrental.car.application.port.in.command.CarAddCommand;

public interface CarAddUseCase {
    void add(CarAddCommand car);
}
