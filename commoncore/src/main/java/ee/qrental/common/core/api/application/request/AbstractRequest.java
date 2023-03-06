package ee.qrental.common.core.api.application.request;

import ee.qrental.common.core.api.application.validation.WithViolations;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class AbstractRequest
        implements WithViolations {
    private List<String> violations = new ArrayList<>();

    public boolean hasViolations() {
        return !violations.isEmpty();
    }
}
