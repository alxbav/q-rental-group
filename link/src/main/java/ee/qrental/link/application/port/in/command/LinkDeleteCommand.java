package ee.qrental.link.application.port.in.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LinkDeleteCommand {
    private Long id;
    private String objectInfo;
}