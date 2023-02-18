package ee.qrental.link.application.port.in.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
public class LinkDeleteCommand {
    @NotNull
    @Getter
    private Long id;
}