package ee.qrental.calculation.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RentCalculationResult {
    private Long id;
    private Long linkId;
    private Long transactionId;
}