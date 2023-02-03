package ee.qrental.car.domain;


import lombok.Getter;

import java.time.LocalDate;

import static java.lang.String.format;

@Getter
public class Car {
    //   private static final Integer FIRST_NAME_MAX_SIZE = 15;
    //   private static final Integer LAST_NAME_MAX_SIZE = 30;
//    private static final Integer PHONE_MAX_SIZE = 30;
    private static final Integer COMMENT_MAX_SIZE = 150;
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
    private String insuranceFirm;
    private LocalDate insuranceDateStart;
    private LocalDate insuranceDateEnd;
    private Boolean sCard;
    private Boolean key2;
    private Boolean gps;
    private LocalDate technicalInspectionEnd;
    private LocalDate gasInspectionEnd;
    private String comment;
    public Car(
            Long id,
            Boolean active,
            Boolean qRent,
            String regNumber,
            String vin,
            LocalDate releaseDate,
            String manufacturer,
            String model,
            Boolean appropriation,
            Boolean elegance,
            String gearType,
            String fuelType,
            Boolean lpg,
            LocalDate dateInstallLpg,
            String insuranceFirm,
            LocalDate insuranceDateStart,
            LocalDate insuranceDateEnd,
            Boolean sCard,
            Boolean key2,
            Boolean gps,
            LocalDate technicalInspectionEnd,
            LocalDate gasInspectionEnd,
            String comment) {
        //    validateFirstName(firstName);
        //      validateLastName(lastName);
        //     validatePhone(phone);
        validateComment(comment);
        this.id = id;
        this.active = active;
        this.qRent = qRent;
        this.regNumber = regNumber;
        this.vin = vin;
        this.releaseDate = releaseDate;
        this.manufacturer = manufacturer;
        this.model = model;
        this.appropriation = appropriation;
        this.elegance = elegance;
        this.gearType = gearType;
        this.fuelType = fuelType;
        this.lpg = lpg;
        this.dateInstallLpg = dateInstallLpg;
        this.insuranceFirm = insuranceFirm;
        this.insuranceDateStart = insuranceDateStart;
        this.insuranceDateEnd = insuranceDateEnd;
        this.sCard = sCard;
        this.key2 = key2;
        this.gps = gps;
        this.technicalInspectionEnd = technicalInspectionEnd;
        this.gasInspectionEnd = gasInspectionEnd;
        this.comment = comment;
    }

    public void setActive(Boolean active) {
         this.active = active;
    }
    public void setQRent(Boolean qRent) {
        this.qRent = qRent;
    }
    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }
    public void setVin(String vin) {
        this.vin = vin;
    }
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setAppropriation(Boolean appropriation) {
        this.appropriation = appropriation;
    }
    public void setElegance(Boolean elegance) {
        this.elegance = elegance;
    }
    public void setGearType(String gearType) {
        this.gearType = gearType;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    public void setLpg(Boolean lpg) {
        this.lpg = lpg;
    }
    public void setDateInstallLpg(LocalDate dateInstallLpg) {
        this.dateInstallLpg = dateInstallLpg;
    }
    public void setInsuranceFirm(String insuranceFirm) {
        this.insuranceFirm = insuranceFirm;
    }
    public void setInsuranceDateStart(LocalDate insuranceDateStart) {
        this.insuranceDateStart = insuranceDateStart;
    }
    public void setInsuranceDateEnd(LocalDate insuranceDateEnd) {
        this.insuranceDateEnd = insuranceDateEnd;
    }
    public void setSCard(Boolean sCard) {
        this.sCard = sCard;
    }
    public void setKey2(Boolean key2) {
        this.key2 = key2;
    }
    public void setGps(Boolean gps) {
        this.gps = gps;
    }
    public void setTechnicalInspectionEnd(LocalDate technicalInspectionEnd) {
        this.technicalInspectionEnd = technicalInspectionEnd;
    }
    public void setGasInspectionEnd(LocalDate gasInspectionEnd) {
        this.gasInspectionEnd = gasInspectionEnd;
    }
    public void setComment(String comment) {
        validateComment(comment);
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
