package ee.qrental.driver.application.port.in.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CallSignLinkDeleteCommand {
    private Long id;
    private String objectInfo;
}