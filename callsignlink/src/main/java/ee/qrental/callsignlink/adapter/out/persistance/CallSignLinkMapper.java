package ee.qrental.link.adapter.out.persistance;

import ee.qrental.link.domain.Link;

public class LinkMapper {

    public Link mapToDomain(final LinkJpaEntity jpaEntity) {
        return new Link(
                jpaEntity.getId(),
                jpaEntity.getCarId(),
                jpaEntity.getDriverId(),
                jpaEntity.getLinkType(),
                jpaEntity.getDateStart(),
                jpaEntity.getDateEnd(),
                jpaEntity.getComment()
        );
    }


    public LinkJpaEntity mapToEntity(final Link domain) {
        return LinkJpaEntity.builder()
                .id(domain.getId())
                .carId(domain.getCarId())
                .driverId(domain.getDriverId())
                .linkType(domain.getLinkType())
                .dateStart(domain.getDateStart())
                .dateEnd(domain.getDateEnd())
                .comment(domain.getComment())
                .build();
    }
}
