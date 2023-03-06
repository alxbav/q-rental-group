package ee.qrental.common.core.api.application.validation;

public interface QValidator<D> {
    ViolationsCollector validate(final D domain);
}
