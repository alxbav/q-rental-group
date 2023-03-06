package ee.qrental.common.core.api.application.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public abstract class AbstractUpdateRequest
        extends AbstractRequest {
    @NotNull
    private Long id;
}
