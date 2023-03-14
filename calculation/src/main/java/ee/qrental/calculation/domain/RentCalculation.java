package ee.qrental.calculation.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class RentCalculation {

    private Long id;
    private LocalDate actionDate;
    private String comment;
    private List<RentCalculationResult> results;
}
