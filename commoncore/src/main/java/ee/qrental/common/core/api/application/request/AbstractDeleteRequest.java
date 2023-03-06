package ee.qrental.common.core.api.application.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public abstract class AbstractDeleteRequest
        extends AbstractRequest {
    @NotNull
    private Long id;
}
