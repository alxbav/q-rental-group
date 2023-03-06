package ee.qrental.job.application.validator;

import ee.qrental.common.core.api.validation.QValidator;
import ee.qrental.common.core.api.validation.ViolationsCollector;
import ee.qrental.job.domain.Job;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JobBusinessRuleValidator implements QValidator<Job> {
    @Override
    public ViolationsCollector validate(final Job link) {
        final var violationsCollector = new ViolationsCollector();
        return violationsCollector;
    }
}
