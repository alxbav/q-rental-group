package ee.qrental.common.core.api.application.mapper;

public interface AddRequestMapper<R, D> {
    D toDomain(final R request);
}