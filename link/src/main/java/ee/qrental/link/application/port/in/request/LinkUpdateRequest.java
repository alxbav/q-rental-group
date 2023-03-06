package ee.qrental.link.application.port.in.request;

import ee.qrental.common.core.api.application.request.AbstractUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkUpdateRequest
        extends AbstractUpdateRequest {

    private Long carId;
    private Long driverId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateStart;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateEnd;
    private String comment;
}