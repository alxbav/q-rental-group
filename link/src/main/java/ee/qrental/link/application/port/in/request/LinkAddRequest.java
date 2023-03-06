package ee.qrental.link.application.port.in.request;

import ee.qrental.common.core.api.application.request.AbstractAddRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class LinkAddRequest
        extends AbstractAddRequest {

    private Long carId;
    private Long driverId;
    private String linkType;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateStart = LocalDate.now();
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateEnd;
    private String comment;
}

