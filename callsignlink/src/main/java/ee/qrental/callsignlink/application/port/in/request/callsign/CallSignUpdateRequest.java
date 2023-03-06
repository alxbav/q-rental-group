package ee.qrental.callsignlink.application.port.in.request.callsign;

import ee.qrental.common.core.api.application.request.AbstractUpdateRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CallSignUpdateRequest
        extends AbstractUpdateRequest {

    private Integer callSign;
    private String comment;
}