package ee.qrental.calculation.application.port.in.request;

import ee.qrental.common.core.api.application.request.AbstractAddRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class RentCalculationAddRequest
        extends AbstractAddRequest {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate actionDate = LocalDate.now();
}
