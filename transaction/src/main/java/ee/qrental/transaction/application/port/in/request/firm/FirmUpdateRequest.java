package ee.qrental.transaction.application.port.in.request.firm;

import ee.qrental.common.core.api.application.request.AbstractUpdateRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FirmUpdateRequest
        extends AbstractUpdateRequest {

    private String name;
    private String iban;
    private Long regNumber;
    private String vatNumber;
    private String comment;
}