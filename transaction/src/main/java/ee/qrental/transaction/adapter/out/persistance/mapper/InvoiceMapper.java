package ee.qrental.transaction.adapter.out.persistance.mapper;

import ee.qrental.transaction.adapter.out.persistance.jpaentity.FirmJpaEntity;
import ee.qrental.transaction.adapter.out.persistance.jpaentity.InvoiceJpaEntity;
import ee.qrental.transaction.domain.Invoice;
import org.springframework.stereotype.Component;

@Component
public class InvoiceMapper {

    public Invoice mapToDomain(final InvoiceJpaEntity jpaEntity) {
        return new Invoice(
                jpaEntity.getId(),
                jpaEntity.getDriverId(),
                jpaEntity.getCallSign(),
                jpaEntity.getDriverCompany(),
                jpaEntity.getDriverCompanyRegNumber(),
                jpaEntity.getDriverCompanyAddress(),
                jpaEntity.getFirmId(),
                jpaEntity.getFirmName(),
                jpaEntity.getRegNumber(),
                jpaEntity.getVatNumber(),
                jpaEntity.getIban(),
                jpaEntity.getBank(),
                jpaEntity.getInvoiceNumber(),
                jpaEntity.getWeekNumber(),
                jpaEntity.getDateCreation(),
                jpaEntity.getDateStamp(),
                jpaEntity.getRent(),
                jpaEntity.getFrsConnectionFee(),
                jpaEntity.getIssuedInCash(),
                jpaEntity.getBankTransfer(),
                jpaEntity.getAutoRepair(),
                jpaEntity.getSelfResponsibility(),
                jpaEntity.getOtherNegative(),
                jpaEntity.getBankTransferFromBolt(),
                jpaEntity.getBankTransferFromCarRenter(),
                jpaEntity.getFrsRsk(),
                jpaEntity.getCashFromRenter(),
                jpaEntity.getBonusFrs(),
                jpaEntity.getBonusBolt(),
                jpaEntity.getDiscount(),
                jpaEntity.getOtherPositive(),
                jpaEntity.getComment()
        );
    }

    public InvoiceJpaEntity  mapToEntity(final Invoice domain) {
        return InvoiceJpaEntity.builder()
                .id(domain.getId())
                .driverId(domain.getDriverId())
                .callSign(domain.getCallSign())
                .driverCompany(domain.getDriverCompany())
                .driverCompanyRegNumber(domain.getDriverCompanyRegNumber())
                .driverCompanyAddress(domain.getDriverCompanyAddress())
                .firmId(domain.getFirmId())
                .firmName(domain.getFirmName())
                .regNumber(domain.getRegNumber())
                .vatNumber(domain.getVatNumber())
                .iban(domain.getIban())
                .bank(domain.getBank())
                .invoiceNumber(domain.getInvoiceNumber())
                .weekNumber(domain.getWeekNumber())
                .dateCreation(domain.getDateCreation())
                .dateStamp(domain.getDateStamp())
                .rent(domain.getRent())
                .frsConnectionFee(domain.getFrsConnectionFee())
                .issuedInCash(domain.getIssuedInCash())
                .bankTransfer(domain.getBankTransfer())
                .autoRepair(domain.getAutoRepair())
                .selfResponsibility(domain.getSelfResponsibility())
                .otherNegative(domain.getOtherNegative())
                .bankTransferFromBolt(domain.getBankTransferFromBolt())
                .bankTransferFromCarRenter(domain.getBankTransferFromCarRenter())
                .frsRsk(domain.getFrsRsk())
                .cashFromRenter(domain.getCashFromRenter())
                .bonusFrs(domain.getBonusFrs())
                .bonusBolt(domain.getBonusBolt())
                .discount(domain.getDiscount())
                .otherPositive(domain.getOtherPositive())
                .comment(domain.getComment())
                .build();
    }
}
