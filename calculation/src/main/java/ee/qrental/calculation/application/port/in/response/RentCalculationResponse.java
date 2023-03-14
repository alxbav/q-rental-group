package ee.qrental.calculation.application.port.in.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class RentCalculationResponse {
    private Long id;
    private LocalDate actionDate;
    private Integer transactionCount;
    private String comment;
}
