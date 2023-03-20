package ee.qrental.car.adapter.out.persistance.mapper;

import ee.qrental.car.adapter.out.persistance.jpaentity.CarJpaEntity;
import ee.qrental.car.domain.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {


    public Car mapToDomain(final CarJpaEntity jpaEntity) {
        return new Car(
                jpaEntity.getId(),
                jpaEntity.getActive(),
                jpaEntity.getQRent(),
                jpaEntity.getRegNumber(),
                jpaEntity.getVin(),
                jpaEntity.getReleaseDate(),
                jpaEntity.getManufacturer(),
                jpaEntity.getModel(),
                jpaEntity.getAppropriation(),
                jpaEntity.getElegance(),
                jpaEntity.getGearType(),
                jpaEntity.getFuelType(),
                jpaEntity.getLpg(),
                jpaEntity.getDateInstallLpg(),
                jpaEntity.getDateEndLpg(),
                jpaEntity.getInsuranceFirm(),
                jpaEntity.getInsuranceDateStart(),
                jpaEntity.getInsuranceDateEnd(),
                jpaEntity.getSCard(),
                jpaEntity.getKey2(),
                jpaEntity.getGps(),
                jpaEntity.getTechnicalInspectionEnd(),
                jpaEntity.getGasInspectionEnd(),
                jpaEntity.getComment()
        );
    }


    public CarJpaEntity mapToEntity(final Car domain) {
        return CarJpaEntity.builder()
                .id(domain.getId())
                .active(domain.getActive())
                .qRent(domain.getQRent())
                .regNumber(domain.getRegNumber())
                .vin(domain.getVin())
                .releaseDate(domain.getReleaseDate())
                .manufacturer(domain.getManufacturer())
                .model(domain.getModel())
                .appropriation(domain.getAppropriation())
                .elegance(domain.getElegance())
                .gearType(domain.getGearType())
                .fuelType(domain.getFuelType())
                .lpg(domain.getLpg())
                .dateInstallLpg(domain.getDateInstallLpg())
                .dateEndLpg(domain.getDateEndLpg())
                .insuranceFirm(domain.getInsuranceFirm())
                .insuranceDateStart(domain.getInsuranceDateStart())
                .insuranceDateEnd(domain.getInsuranceDateEnd())
                .sCard(domain.getSCard())
                .key2(domain.getKey2())
                .gps(domain.getGps())
                .technicalInspectionEnd(domain.getTechnicalInspectionEnd())
                .gasInspectionEnd(domain.getGasInspectionEnd())
                .comment(domain.getComment())
                .build();
    }
}
