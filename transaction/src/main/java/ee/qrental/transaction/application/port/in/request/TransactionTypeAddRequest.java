package ee.qrental.transaction.application.port.in.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionTypeAddRequest {
    private String name;
    private String description;
    private Boolean negative;
    private String comment;

}