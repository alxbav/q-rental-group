package ee.qrental.transaction.application.port.in.mapper.invoice;

import ee.qrental.common.core.api.application.mapper.UpdateRequestMapper;
import ee.qrental.transaction.application.port.in.request.invoice.InvoiceUpdateRequest;
import ee.qrental.transaction.domain.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InvoiceUpdateRequestMapper
        implements UpdateRequestMapper<InvoiceUpdateRequest, Invoice> {

    @Override
    public Invoice toDomain(final InvoiceUpdateRequest request) {
        final var domain = new Invoice();
        domain.setId(request.getId());
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

    @Override
    public InvoiceUpdateRequest toRequest(final Invoice domain) {
        final var request = new InvoiceUpdateRequest();

        request.setId(domain.getId());
        request.setCallSign(domain.getCallSign());
        request.setDriverCompany(domain.getDriverCompany());
        request.setDriverCompanyRegNumber(domain.getDriverCompanyRegNumber());
        request.setFirmId(domain.getFirmId());
        request.setFirmName(domain.getFirmName());
        request.setRegNumber(domain.getRegNumber());
        request.setVatNumber(domain.getVatNumber());
        request.setIban(domain.getIban());
        request.setBank(domain.getBank());
        request.setInvoiceNumber(domain.getInvoiceNumber());
        request.setWeekNumber(domain.getWeekNumber());
        request.setDateCreation(domain.getDateCreation());
        request.setDateStamp(domain.getDateStamp());
        request.setRent(domain.getRent());
        request.setFrsConnectionFee(domain.getFrsConnectionFee());
        request.setIssuedInCash(domain.getIssuedInCash());
        request.setBankTransfer(domain.getBankTransfer());
        request.setAutoRepair(domain.getAutoRepair());
        request.setSelfResponsibility(domain.getSelfResponsibility());
        request.setOtherNegative(domain.getOtherNegative());
        request.setBankTransferFromBolt(domain.getBankTransferFromBolt());
        request.setBankTransferFromCarRenter(domain.getBankTransferFromCarRenter());
        request.setFrsRsk(domain.getFrsRsk());
        request.setCashFromRenter(domain.getCashFromRenter());
        request.setBonusFrs(domain.getBonusFrs());
        request.setBonusBolt(domain.getBonusBolt());
        request.setDiscount(domain.getDiscount());
        request.setOtherPositive(domain.getOtherPositive());
        request.setComment(domain.getComment());

        return request;
    }
}
