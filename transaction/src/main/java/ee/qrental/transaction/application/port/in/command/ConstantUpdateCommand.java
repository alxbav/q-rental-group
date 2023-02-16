package ee.qrental.transaction.application.port.in.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ConstantUpdateCommand {

    private Long id;
    private String name;
    private Double value;
    private String description;
    private Boolean negative;

}