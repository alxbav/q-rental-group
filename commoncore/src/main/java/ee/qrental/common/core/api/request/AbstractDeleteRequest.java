package ee.qrental.common.core.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public abstract class AbstractDeleteRequest {
    @NotNull
    private Long id;
}
