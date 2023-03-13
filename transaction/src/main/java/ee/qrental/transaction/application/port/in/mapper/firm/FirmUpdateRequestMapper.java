package ee.qrental.transaction.application.port.in.mapper.firm;

import ee.qrental.common.core.api.application.mapper.UpdateRequestMapper;
import ee.qrental.transaction.application.port.in.request.firm.FirmUpdateRequest;
import ee.qrental.transaction.domain.Firm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FirmUpdateRequestMapper
        implements UpdateRequestMapper<FirmUpdateRequest, Firm> {

    @Override
    public Firm toDomain(final FirmUpdateRequest request) {
        final var domain = new Firm();
        domain.setId(request.getId());
        domain.setName(request.getName());
        domain.setIban(request.getIban());
        domain.setRegNumber(request.getRegNumber());
        domain.setVatNumber(request.getVatNumber());
        domain.setComment(request.getComment());
        domain.setEMail(request.getEMail());
        domain.setPostAddress(request.getPostAddress());
        domain.setPhone(request.getPhone());
        domain.setBank(request.getBank());
        domain.setQGroup(request.getQGroup());

        return domain;
    }

    @Override
    public FirmUpdateRequest toRequest(final Firm domain) {
        final var request = new FirmUpdateRequest();
        request.setId(domain.getId());
        request.setName(domain.getName());
        request.setIban(domain.getIban());
        request.setRegNumber(domain.getRegNumber());
        request.setVatNumber(domain.getVatNumber());
        request.setComment(domain.getComment());
        request.setEMail(domain.getEMail());
        request.setPostAddress(domain.getPostAddress());
        request.setPhone(domain.getPhone());
        request.setBank(domain.getBank());
        request.setQGroup(domain.getQGroup());

        return request;
    }
}
