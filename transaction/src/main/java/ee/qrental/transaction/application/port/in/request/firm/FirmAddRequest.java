package ee.qrental.transaction.application.port.in.request.firm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FirmAddRequest {
    private String name;
    private String iban;
    private Long regNumber;
    private String vatNumber;
    private String eMail;
    private String postAddress;
    private String phone;
    private String bank;
    private String comment;

}