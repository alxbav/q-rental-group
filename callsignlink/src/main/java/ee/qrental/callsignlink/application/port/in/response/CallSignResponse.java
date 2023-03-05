package ee.qrental.callsignlink.application.port.in.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CallSignResponse {
    private Long id;
    private Integer callSign;
    private String comment;
}
