package ee.qrental.link.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private static final Integer COMMENT_MAX_SIZE = 150;
    private Long id;
    private Long carId;
    private Long driverId;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String comment;

    public Boolean isActive() {
        return dateEnd == null;
    }
}
