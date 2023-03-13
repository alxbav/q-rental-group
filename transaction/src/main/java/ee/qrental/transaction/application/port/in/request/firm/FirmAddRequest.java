package ee.qrental.transaction.application.port.in.request.firm;

import ee.qrental.common.core.api.application.request.AbstractAddRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class FirmAddRequest
        extends AbstractAddRequest {
    private String name;
    private String iban;
    private Long regNumber;
    private String vatNumber;
    private String comment;
    private String eMail;
    private String postAddress;
    private String phone;
    private String bank;
    private Boolean qGroup;


}