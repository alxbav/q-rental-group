package ee.qrental.transaction.application.port.in.mapper.firm;

import ee.qrental.common.core.api.application.mapper.ResponseMapper;
import ee.qrental.transaction.application.port.in.response.firm.FirmResponse;
import ee.qrental.transaction.domain.Firm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
@AllArgsConstructor
public class FirmResponseMapper
        implements ResponseMapper<FirmResponse, Firm> {
    @Override
    public FirmResponse toResponse(final Firm domain) {
        return FirmResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .iban(domain.getIban())
                .regNumber(domain.getRegNumber())
                .vatNumber(domain.getVatNumber())
                .comment(domain.getComment())
                .eMail(domain.getEMail())
                .postAddress(domain.getPostAddress())
                .phone(domain.getPhone())
                .bank(domain.getBank())
                .build();
    }

    @Override
    public String toObjectInfo(Firm domain) {
        return format("Firm : %s ",
                domain.getName());
    }
}
