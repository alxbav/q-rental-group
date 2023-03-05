package ee.qrental.callsignlink.application.port.in.request.callsign;

import ee.qrental.common.core.api.request.AbstractUpdateRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CallSignUpdateRequest extends AbstractUpdateRequest {

    private Integer callSign;
    private String comment;

    private List<String> violations = new ArrayList<>();

    public boolean hasViolations() {
        return !violations.isEmpty();
    }
}