package ee.qrental.car.application.port.in.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@SuperBuilder
@Getter
@Setter

public class CarResponse {
    private Long id;
    private Boolean active;
    private Boolean qRent;
    private String regNumber;
    private String vin;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate releaseDate;
    private String manufacturer;
    private String model;
    private Boolean appropriation;
    private Boolean elegance;
    private String gearType;
    private String fuelType;
    private Boolean lpg;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateInstallLpg;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateEndLpg;
    private String insuranceFirm;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate insuranceDateStart;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate insuranceDateEnd;
    private Boolean sCard;
    private Boolean key2;
    private Boolean gps;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate technicalInspectionEnd;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate gasInspectionEnd;
    private String comment;
}
