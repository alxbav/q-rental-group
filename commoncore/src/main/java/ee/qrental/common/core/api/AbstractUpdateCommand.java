package ee.qrental.common.core.api;

import lombok.Getter;

import javax.validation.constraints.NotNull;


public abstract class AbstractUpdateCommand<T> extends SelfValidating<T>  {
    @NotNull
    @Getter
    private Long id;

    public AbstractUpdateCommand(Long id) {
        this.id = id;
        super.validateSelf();
    }
}
