package ee.qrental.transaction.application.port.in.mapper.invoice;

import ee.qrental.common.core.api.application.mapper.AddRequestMapper;
import ee.qrental.transaction.application.port.in.request.invoice.InvoiceAddRequest;
import ee.qrental.transaction.domain.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InvoiceAddRequestMapper
        implements AddRequestMapper<InvoiceAddRequest, Invoice> {

    @Override
    public Invoice toDomain(InvoiceAddRequest request) {
        final var domain = new Invoice();
        domain.setId(null);
        domain.setDriverId(request.getDriverId());
        domain.setCallSign(request.getCallSign());
        domain.setDriverCompany(request.getDriverCompany());
        domain.setDriverCompanyRegNumber(request.getDriverCompanyRegNumber());
        domain.setFirmId(request.getFirmId());
        domain.setFirmName(request.getFirmName());
        domain.setRegNumber(request.getRegNumber());
        domain.setVatNumber(request.getVatNumber());
        domain.setIban(request.getIban());
        domain.setBank(request.getBank());
        domain.setInvoiceNumber(request.getInvoiceNumber());
        domain.setWeekNumber(request.getWeekNumber());
        domain.setDateCreation(request.getDateCreation());
        domain.setDateStamp(request.getDateStamp());
        domain.setRent(request.getRent());
        domain.setFrsConnectionFee(request.getFrsConnectionFee());
        domain.setIssuedInCash(request.getIssuedInCash());
        domain.setBankTransfer(request.getBankTransfer());
        domain.setAutoRepair(request.getAutoRepair());
        domain.setSelfResponsibility(request.getSelfResponsibility());
        domain.setOtherNegative(request.getOtherNegative());
        domain.setBankTransferFromBolt(request.getBankTransferFromBolt());
        domain.setBankTransferFromCarRenter(request.getBankTransferFromCarRenter());
        domain.setFrsRsk(request.getFrsRsk());
        domain.setCashFromRenter(request.getCashFromRenter());
        domain.setBonusFrs(request.getBonusFrs());
        domain.setBonusBolt(request.getBonusBolt());
        domain.setDiscount(request.getDiscount());
        domain.setOtherPositive(request.getOtherPositive());
        domain.setComment(request.getComment());

        return domain;
    }
}
