package ee.qrental.transaction.application.port.in.mapper.firm;

import ee.qrental.common.core.api.application.mapper.AddRequestMapper;
import ee.qrental.transaction.application.port.in.request.firm.FirmAddRequest;
import ee.qrental.transaction.domain.Firm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FirmAddRequestMapper
        implements AddRequestMapper<FirmAddRequest, Firm> {

    @Override
    public Firm toDomain(FirmAddRequest request) {
        final var domain = new Firm();
        domain.setId(null);
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
}
