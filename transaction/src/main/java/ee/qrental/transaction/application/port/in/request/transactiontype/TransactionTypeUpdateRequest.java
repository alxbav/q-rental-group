package ee.qrental.transaction.application.port.in.request.transactiontype;

import ee.qrental.common.core.api.application.request.AbstractUpdateRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionTypeUpdateRequest
        extends AbstractUpdateRequest {

    private String name;
    private String description;
    private Boolean negative;
    private String comment;
}