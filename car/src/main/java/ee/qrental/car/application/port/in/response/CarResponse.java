package ee.qrental.car.application.port.in.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarResponse {
    private Long id;
    private String regNumber;
    private LocalDate releaseDate;
    private String manufacturer;
    private String model;
    private String gearType;
    private String fuelType;
    private String comment;
}
