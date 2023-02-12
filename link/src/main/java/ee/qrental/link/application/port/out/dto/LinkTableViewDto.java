package ee.qrental.link.application.port.out.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
public class LinkTableViewDto {
    private Long id;
    private Long carId;
    private Long driverId;
    private String linkType;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String comment;
}
