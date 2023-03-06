package ee.qrental.common.core.api.adapter.mapper;

public interface DomainMapper<D, E> {
    D mapToDomain(final E jpaEntity);

    E mapToEntity(final D domain);
}
