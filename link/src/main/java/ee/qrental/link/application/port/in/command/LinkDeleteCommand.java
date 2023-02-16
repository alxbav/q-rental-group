package ee.qrental.link.application.port.in.command;

import ee.qrental.common.core.api.AbstractDeleteCommand;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;



public class LinkDeleteCommand extends AbstractDeleteCommand {
    public LinkDeleteCommand(Long id) {
        super(id);
    }
}