package ee.qrental.common.core.api.application.usecase;

public interface AddUseCase<R> {
    Long add(R request);
}
