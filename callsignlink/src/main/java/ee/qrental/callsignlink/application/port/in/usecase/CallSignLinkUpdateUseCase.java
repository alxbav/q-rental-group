package ee.qrental.link.application.port.in.usecase;

import ee.qrental.link.application.port.in.request.LinkUpdateCommand;

public interface LinkUpdateUseCase {
    void update(LinkUpdateCommand link);
}
