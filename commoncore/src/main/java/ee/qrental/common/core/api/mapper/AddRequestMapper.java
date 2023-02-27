package ee.qrental.common.core.api.mapper;

public interface AddRequestMapper<R, D> {

    D toDomain(final R request);

}