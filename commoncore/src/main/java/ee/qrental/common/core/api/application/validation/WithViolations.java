package ee.qrental.common.core.api.application.validation;

import java.util.List;

public interface WithViolations {
    List<String> getViolations();

    void setViolations(final List<String> violations);

    boolean hasViolations();
}
