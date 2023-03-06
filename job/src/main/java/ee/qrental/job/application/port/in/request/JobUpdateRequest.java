package ee.qrental.job.application.port.in.request;

import ee.qrental.common.core.api.request.AbstractUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobUpdateRequest extends AbstractUpdateRequest {
    private String name;
    private String comment;
}