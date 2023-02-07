package ee.qrental.driver.adapter.out.persistance;

import ee.qrental.driver.domain.CallSignLink;

public class CallSignLinkMapper {

    public CallSignLink mapToDomain(final CallSignLinkJpaEntity jpaEntity) {
        return new CallSignLink(
                jpaEntity.getId(),
                jpaEntity.getCallSign(),
                jpaEntity.getDriver().getId(),
                jpaEntity.getDateStart(),
                jpaEntity.getDateEnd(),
                jpaEntity.getComment()
        );
    }

    public CallSignLinkJpaEntity mapToEntity(final CallSignLink domain) {
        return CallSignLinkJpaEntity.builder()
                .id(domain.getId())
                .callSign(domain.getCallSign())
                .dateStart(domain.getDateStart())
                .dateEnd(domain.getDateEnd())
                .comment(domain.getComment())
                .build();
    }
}
