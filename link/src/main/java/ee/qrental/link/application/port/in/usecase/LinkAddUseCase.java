package ee.qrental.link.application.port.in.usecase;

import ee.qrental.link.application.port.in.command.LinkAddCommand;

public interface LinkAddUseCase {
    void add(LinkAddCommand link);
}
