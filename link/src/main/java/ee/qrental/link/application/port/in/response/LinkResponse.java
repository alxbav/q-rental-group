package ee.qrental.link.application.port.in.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class LinkResponse {
    private Long id;
    private Long carId;
    private Long driverId;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String comment;
}
