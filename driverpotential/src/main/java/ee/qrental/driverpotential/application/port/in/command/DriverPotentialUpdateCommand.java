package ee.qrental.driverpotential.application.port.in.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DriverPotentialUpdateCommand {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String comment;

}