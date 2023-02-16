package ee.qrental.common.core.api;

import lombok.Getter;

import javax.validation.constraints.NotNull;


public abstract class AbstractDeleteCommand<T> extends SelfValidating<T> {

    @NotNull
    @Getter
    private Long id;

    public AbstractDeleteCommand(Long id) {
        this.id = id;
        super.validateSelf();
    }
}
