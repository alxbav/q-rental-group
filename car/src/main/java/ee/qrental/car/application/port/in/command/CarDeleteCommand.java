package ee.qrental.car.application.port.in.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarDeleteCommand {
    private Long id;
    private String objectInfo;
}