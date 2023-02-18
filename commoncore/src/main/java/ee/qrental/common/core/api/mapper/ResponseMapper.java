package ee.qrental.common.core.api.mapper;

public interface ResponseMapper<U, R, D> {
    R toResponse(final D domain);

    String toObjectInfo(final D domain);

    U toUpdateRequest(final D domain);

}
