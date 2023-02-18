package ee.qrental.transaction.application.port.in.response.transactiontype;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class TransactionTypeResponse {
    private Long id;
    private String name;
    private String description;
    private Boolean negative;
    private String comment;
}
