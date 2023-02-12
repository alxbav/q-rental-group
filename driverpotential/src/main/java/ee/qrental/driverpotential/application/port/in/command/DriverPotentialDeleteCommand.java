package ee.qrental.driverpotential.application.port.in.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DriverPotentialDeleteCommand {
    private Long id;
    private String objectInfo;
}