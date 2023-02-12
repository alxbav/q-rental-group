package ee.qrental.link.domain;


import lombok.Getter;

import java.time.LocalDate;

import static java.lang.String.format;


@Getter
public class Link {


    private static final Integer COMMENT_MAX_SIZE = 150;
    private Long id;
    private Long carId;
    private Long driverId;
    private String linkType;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String comment;

    public Link(Long id,
                Long carId,
                Long driverId,
                String linkType,
                LocalDate dateStart,
                LocalDate dateEnd,
                String comment) {
        validateComment(comment);
        this.id = id;
        this.carId = carId;
        this.driverId = driverId;
        this.linkType = linkType;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public Long getCarId() {
        return carId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public String getLinkType() {
        return linkType;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public String getComment() {
        return comment;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
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

    private void validateComment(final String comment) {
        final var length = comment.length();
        if (length > COMMENT_MAX_SIZE) {
            throw new RuntimeException(format("Comment length is %d. Comment must not exceed %d",
                    length, COMMENT_MAX_SIZE));
        }
    }
}
