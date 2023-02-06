package ee.qrental.transaction.application.port.in.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionTypeAddCommand {
    private String name;
    private String description;
    private String comment;

}