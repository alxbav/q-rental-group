package ee.qrental.transaction.application.port.in.mapper;

import ee.qrental.common.core.api.mapper.ResponseMapper;
import ee.qrental.transaction.application.port.in.request.firm.FirmUpdateRequest;
import ee.qrental.transaction.application.port.in.response.firm.FirmResponse;
import ee.qrental.transaction.domain.Firm;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
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
                .build();
    }

    @Override
    public String toObjectInfo(Firm domain) {
        return format("Firm : %s ",
                domain.getName());
    }
}
