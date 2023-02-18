package ee.qrental.common.core.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public abstract class AbstractUpdateRequest {
    @NotNull
    private Long id;
}
