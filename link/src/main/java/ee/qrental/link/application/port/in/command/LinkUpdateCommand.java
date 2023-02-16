package ee.qrental.link.application.port.in.command;

import ee.qrental.common.core.api.AbstractUpdateCommand;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class LinkUpdateCommand extends AbstractUpdateCommand<LinkUpdateCommand> {
    private Long carId;
    private Long driverId;
    private String linkType;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateStart;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateEnd;
    private String comment;
    public LinkUpdateCommand(Long id, Long carId, Long driverId, String linkType, LocalDate dateStart, LocalDate dateEnd, String comment) {
        super(id);
        this.carId = carId;
        this.driverId = driverId;
        this.linkType = linkType;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.comment = comment;
    }

}