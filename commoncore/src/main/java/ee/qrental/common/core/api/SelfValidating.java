package ee.qrental.common.core.api;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static javax.validation.Validation.buildDefaultValidatorFactory;

public abstract class SelfValidating<T> {

    private static ValidatorFactory factory = buildDefaultValidatorFactory();
    private Validator validator;

    public SelfValidating() {
        validator = factory.getValidator();
    }

    protected void validateSelf() {
        final var violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
