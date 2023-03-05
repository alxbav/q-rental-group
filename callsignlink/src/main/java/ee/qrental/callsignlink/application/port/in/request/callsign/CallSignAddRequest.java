package ee.qrental.callsignlink.application.port.in.request.callsign;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CallSignAddRequest {
    private Integer callSign;
    private String comment;
    private List<String> violations = new ArrayList<>();

    public boolean hasViolations() {
        return !violations.isEmpty();
    }
}

