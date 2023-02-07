package ee.qrental.driver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class CallSignLink {
    private Long id;

    private Integer callSign;

    private Long driverId;

    private LocalDate dateStart;

    private LocalDate dateEnd;

    private String comment;
}
