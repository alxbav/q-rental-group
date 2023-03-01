package ee.qrental.common.core.api.validation;

public interface QValidator<D> {
    ViolationsCollector validate(final D domain);
}
