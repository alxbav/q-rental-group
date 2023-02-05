package ee.qrental.link.application.port.in.usecase;

import ee.qrental.link.application.port.in.command.LinkUpdateCommand;

public interface LinkUpdateUseCase {
    void update(LinkUpdateCommand link);
}
