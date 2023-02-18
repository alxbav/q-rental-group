package ee.qrental.transaction.application.port.in.request;

import ee.qrental.common.core.api.request.AbstractDeleteRequest;
import lombok.AllArgsConstructor;

import javax.validation.constraints.NotNull;

public class TransactionDeleteRequest extends AbstractDeleteRequest {
    public TransactionDeleteRequest(@NotNull Long id) {
        super(id);
    }
}