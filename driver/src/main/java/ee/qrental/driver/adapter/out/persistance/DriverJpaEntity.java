package ee.qrental.driver.adapter.out.persistance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;


@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "driver")
public class DriverJpaEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "isikukood")
    private Long isikukood;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "iban1")
    private String iban1;

    @Column(name = "iban2")
    private String iban2;

    @Column(name = "iban3")
    private String iban3;

    @Column(name = "driver_license_number")
    private String driverLicenseNumber;

    @Column(name = "driver_license_exp")
    private LocalDate driverLicenseExp;


    @Column(name = "taxi_license")
    private String taxiLicense;


    @Column(name = "address")
    private String address;


    @Column(name = "comment")
    private String comment;
}
