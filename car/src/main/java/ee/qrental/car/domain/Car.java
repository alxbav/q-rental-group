package ee.qrental.car.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private Long id;
    private Boolean active;
    private Boolean qRent;
    private String regNumber;
    private String vin;
    private LocalDate releaseDate;
    private String manufacturer;
    private String model;
    private Boolean appropriation;
    private Boolean elegance;
    private String gearType;
    private String fuelType;
    private Boolean lpg;
    private LocalDate dateInstallLpg;
    private LocalDate dateEndLpg;
    private String insuranceFirm;
    private LocalDate insuranceDateStart;
    private LocalDate insuranceDateEnd;
    private Boolean sCard;
    private Boolean key2;
    private Boolean gps;
    private LocalDate technicalInspectionEnd;
    private LocalDate gasInspectionEnd;
    private String comment;
}
