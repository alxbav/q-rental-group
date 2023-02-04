package ee.qrental.transactiontype.application.port.in.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionTypeUpdateCommand {

    private Long id;
    private String typeTr;
    private String description;
    private String comment;

}