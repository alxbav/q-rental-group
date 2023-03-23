package ee.qrental.driver.adapter.out.persistance.mapper;

import ee.qrental.driver.adapter.out.persistance.jpaentity.DriverJpaEntity;
import ee.qrental.driver.domain.Driver;
import org.springframework.stereotype.Component;

@Component
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
                jpaEntity.getCompany(),
                jpaEntity.getRegNumber(),
                jpaEntity.getCompanyAddress(),
                jpaEntity.getDriverLicenseNumber(),
                jpaEntity.getDriverLicenseExp(),
                jpaEntity.getTaxiLicense(),
                jpaEntity.getAddress(),
                jpaEntity.getComment(),
                jpaEntity.getDeposit()
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
                .company(domain.getCompany())
                .regNumber(domain.getRegNumber())
                .companyAddress(domain.getCompanyAddress())
                .driverLicenseNumber(domain.getDriverLicenseNumber())
                .driverLicenseExp(domain.getDriverLicenseExp())
                .taxiLicense(domain.getTaxiLicense())
                .address(domain.getAddress())
                .comment(domain.getComment())
                .deposit(domain.getDeposit())
                .build();
    }
}