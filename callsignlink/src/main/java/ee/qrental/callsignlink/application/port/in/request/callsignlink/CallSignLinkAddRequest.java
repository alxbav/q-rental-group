package ee.qrental.callsignlink.application.port.in.request.callsignlink;

import ee.qrental.common.core.api.application.request.AbstractAddRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CallSignLinkAddRequest
        extends AbstractAddRequest {

    private Long driverId;
    private Long callSignId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateStart = LocalDate.now();
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateEnd;
    private String comment;
}

