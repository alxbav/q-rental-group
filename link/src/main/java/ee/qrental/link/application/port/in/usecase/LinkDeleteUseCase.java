package ee.qrental.link.application.port.in.usecase;

import ee.qrental.link.application.port.in.command.LinkDeleteCommand;

public interface LinkDeleteUseCase {
    void delete(LinkDeleteCommand deleteCommand);
}

