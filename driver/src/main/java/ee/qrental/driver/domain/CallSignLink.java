package ee.qrental.driver.domain;


import lombok.Getter;

import java.time.LocalDate;

import static java.lang.String.format;

@Getter

public class CallSignLink {
    private Long id;

    private Integer callSign;

    private Long driverId;

    private LocalDate dateStart;

    private LocalDate dateEnd;

    private String comment;


    public CallSignLink(Long id,
                        Integer callSign,
                        Long driverId,
                        LocalDate dateStart,
                        LocalDate dateEnd,
                        String comment) {
        this.id = id;
        this.callSign = callSign;
        this.driverId = driverId;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.comment = comment;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCallSign(Integer callSign) {
        this.callSign = callSign;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
