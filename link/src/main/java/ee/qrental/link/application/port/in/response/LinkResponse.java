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
    private String carInfo;
    private Long driverId;
    private String driverInfo;
    private Long callSignId;
    private Integer callSign;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String comment;
}
