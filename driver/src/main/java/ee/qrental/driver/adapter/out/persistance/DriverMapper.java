package ee.qrental.driver.adapter.out.persistance;

import ee.qrental.driver.domain.Driver;

public class DriverMapper {

    public Driver mapToDomain(final DriverJpaEntity jpaEntity) {
        return new Driver(
                jpaEntity.getId(),
                jpaEntity.getActive(),
                jpaEntity.getFirstName(),
                jpaEntity.getLastName(),
                jpaEntity.getIsikukood(),
                jpaEntity.getPhone(),
                jpaEntity.getEmail(),
                jpaEntity.getIban1(),
                jpaEntity.getIban2(),
                jpaEntity.getIban3(),
                jpaEntity.getDriverLicenseNumber(),
                jpaEntity.getDriverLicenseExp(),
                jpaEntity.getTaxiLicense(),
                jpaEntity.getAddress(),
                jpaEntity.getComment()
        );
    }

    public DriverJpaEntity mapToEntity(final Driver domain) {
        return DriverJpaEntity.builder()
                .id(domain.getId())
                .active(domain.getActive())
                .firstName(domain.getFirstName())
                .lastName(domain.getLastName())
                .isikukood(domain.getIsikukood())
                .phone(domain.getPhone())
                .email(domain.getEmail())
                .iban1(domain.getIban1())
                .iban2(domain.getIban2())
                .iban3(domain.getIban3())
                .driverLicenseNumber(domain.getDriverLicenseNumber())
                .driverLicenseExp(domain.getDriverLicenseExp())
                .taxiLicense(domain.getTaxiLicense())
                .address(domain.getAddress())
                .comment(domain.getComment())
                .build();
    }
}
