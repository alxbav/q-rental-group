package ee.qrental.driverpotential.adapter.out.persistance;

import ee.qrental.driverpotential.domain.DriverPotential;

public class DriverPotentialMapper {

    public DriverPotential mapToDomain(final DriverPotentialJpaEntity jpaEntity){
        return new DriverPotential(
                jpaEntity.getId(),
                jpaEntity.getFirstName(),
                jpaEntity.getLastName(),
                jpaEntity.getPhone(),
                jpaEntity.getActive(),
                jpaEntity.getComment()
        );
    }

    public DriverPotentialJpaEntity mapToEntity(final DriverPotential domain){
        return DriverPotentialJpaEntity.builder()
                .id(domain.getId())
                .firstName(domain.getFirstName())
                .lastName(domain.getLastName())
                .phone(domain.getPhone())
                .comment(domain.getComment())
                .active(domain.getActive())
                .build();
    }
}
