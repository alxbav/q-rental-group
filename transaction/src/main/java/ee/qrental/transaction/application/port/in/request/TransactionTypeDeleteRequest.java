package ee.qrental.transaction.application.port.in.request;

import ee.qrental.common.core.api.request.AbstractDeleteRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

public class TransactionTypeDeleteRequest extends AbstractDeleteRequest {
    public TransactionTypeDeleteRequest(@NotNull Long id) {
        super(id);
    }
}