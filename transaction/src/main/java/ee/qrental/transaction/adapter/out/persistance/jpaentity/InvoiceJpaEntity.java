package ee.qrental.transaction.adapter.out.persistance.jpaentity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;


@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "invoice")
public class InvoiceJpaEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "driver_id")
    private Long driverId;
    @Column(name = "call_sign")
    private Long callSign;
    @Column(name = " driver_company")
    private String driverCompany;
    @Column(name = " driver_company_reg_number")
    private String driverCompanyRegNumber;
    @Column(name = " driver_company_address")
    private String driverCompanyAddress;
    @Column(name = "firm_id")
    private Long firmId;
    @Column(name = "firm_name")
    private String firmName;
    @Column(name = "reg_number")
    private Long regNumber;
    @Column(name = "vat_number")
    private String vatNumber;
    @Column(name = "iban")
    private String iban;
    @Column(name = " bank")
    private String bank;
    @Column(name = "invoice_number")
    private String invoiceNumber;
    @Column(name = "week_number")
    private Long weekNumber;
    @Column(name = "date_creation")
    private LocalDate dateCreation;
    @Column(name = "date_stamp")
    private LocalDate dateStamp;

    @Column(name = "rent")
    private BigDecimal rent;
    @Column(name = "frs_connection_fee")
    private BigDecimal frsConnectionFee;
    @Column(name = "issued_in_cash")
    private BigDecimal issuedInCash;
    @Column(name = "bank_transfer")
    private BigDecimal bankTransfer;
    @Column(name = "auto_repair")
    private BigDecimal autoRepair;
    @Column(name = "self_responsibility")
    private BigDecimal selfResponsibility;
    @Column(name = "other_negative")
    private BigDecimal otherNegative;

    @Column(name = "bank_transfer_from_bolt")
    private BigDecimal bankTransferFromBolt;
    @Column(name = "bank_transfer_from_car_renter")
    private BigDecimal bankTransferFromCarRenter;
    @Column(name = "frs_rsk")
    private BigDecimal frsRsk;
    @Column(name = "cash_from_renter")
    private BigDecimal cashFromRenter;
    @Column(name = "bonus_frs")
    private BigDecimal bonusFrs;
    @Column(name = "bonus_bolt")
    private BigDecimal bonusBolt;
    @Column(name = "discount")
    private BigDecimal discount;
    @Column(name = "other_positive")
    private BigDecimal otherPositive;

    @Column(name = "comment")
    private String comment;

}
