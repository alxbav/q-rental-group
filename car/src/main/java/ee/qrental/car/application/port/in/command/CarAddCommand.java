package ee.qrental.car.application.port.in.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CarAddCommand {
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