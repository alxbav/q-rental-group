package ee.qrental.transaction.application.port.in.response.firm;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class FirmResponse {
    private Long id;
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
