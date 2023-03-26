package ee.qrental.transaction.application.port.in.mapper.invoice;

import ee.qrental.common.core.api.application.mapper.ResponseMapper;
import ee.qrental.transaction.application.port.in.response.invoice.InvoiceResponse;
import ee.qrental.transaction.domain.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
@AllArgsConstructor
public class InvoiceResponseMapper
        implements ResponseMapper<InvoiceResponse, Invoice> {
    @Override
    public InvoiceResponse toResponse(final Invoice domain) {
        return InvoiceResponse.builder()
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

    @Override
    public String toObjectInfo(Invoice domain) {
        return format("Invoice : %s ",
                domain.getId());
    }
}
