package ee.qrental.common.core.api.application.validation;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Getter
public class ViolationsCollector {
    private final List<String> violations = new ArrayList<>();

    public boolean hasViolations() {
        return !violations.isEmpty();
    }

    public void collect(String... violations) {
        this.violations.addAll(asList(violations));
    }
}
