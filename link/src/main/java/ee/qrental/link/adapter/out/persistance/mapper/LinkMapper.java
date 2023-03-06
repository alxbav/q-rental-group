package ee.qrental.link.adapter.out.persistance.mapper;

import ee.qrental.common.core.api.adapter.mapper.DomainMapper;
import ee.qrental.link.adapter.out.persistance.jpaentity.LinkJpaEntity;
import ee.qrental.link.domain.Link;
import org.springframework.stereotype.Component;

@Component
public class LinkMapper
        implements DomainMapper<Link, LinkJpaEntity> {

    @Override
    public Link mapToDomain(final LinkJpaEntity jpaEntity) {
        return new Link(
                jpaEntity.getId(),
                jpaEntity.getCarId(),
                jpaEntity.getDriverId(),
                jpaEntity.getDateStart(),
                jpaEntity.getDateEnd(),
                jpaEntity.getComment()
        );
    }

    @Override
    public LinkJpaEntity mapToEntity(final Link domain) {
        return LinkJpaEntity.builder()
                .id(domain.getId())
                .carId(domain.getCarId())
                .driverId(domain.getDriverId())
                .dateStart(domain.getDateStart())
                .dateEnd(domain.getDateEnd())
                .comment(domain.getComment())
                .build();
    }
}
