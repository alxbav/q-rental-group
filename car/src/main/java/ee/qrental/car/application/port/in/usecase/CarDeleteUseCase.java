package ee.qrental.car.application.port.in.usecase;

import ee.qrental.car.application.port.in.command.CarDeleteCommand;

public interface CarDeleteUseCase {
    void delete(CarDeleteCommand deleteCommand);
}
