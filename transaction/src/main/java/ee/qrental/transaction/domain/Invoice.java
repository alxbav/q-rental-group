package ee.qrental.transaction.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;

import static java.lang.String.format;

@Getter
@Setter
@NoArgsConstructor

public class Invoice {

    private static final Integer COMMENT_MAX_SIZE = 150;
    private Long id;
    private Long driverId;
    private Long callSign;
    private String driverCompany;
    private String driverCompanyRegNumber;
    private String driverCompanyAddress;
    private Long firmId;
    private String firmName;
    private Long regNumber;
    private String vatNumber;
    private String iban;
    private String bank;
    private String invoiceNumber;
    private Long weekNumber;
    private LocalDate dateCreation;
    private LocalDate dateStamp;
    private BigDecimal rent;
    private BigDecimal frsConnectionFee;
    private BigDecimal issuedInCash;
    private BigDecimal bankTransfer;
    private BigDecimal autoRepair;
    private BigDecimal selfResponsibility;
    private BigDecimal otherNegative;
    private BigDecimal bankTransferFromBolt;
    private BigDecimal bankTransferFromCarRenter;
    private BigDecimal frsRsk;
    private BigDecimal cashFromRenter;
    private BigDecimal bonusFrs;
    private BigDecimal bonusBolt;
    private BigDecimal discount;
    private BigDecimal otherPositive;
    private String comment;

    public Invoice(Long id, Long driverId, Long callSign, String driverCompany,
                   String driverCompanyRegNumber, String driverCompanyAddress,
                   Long firmId, String firmName, Long regNumber, String vatNumber,
                   String iban, String bank, String invoiceNumber, Long weekNumber,
                   LocalDate dateCreation, LocalDate dateStamp, BigDecimal rent,
                   BigDecimal frsConnectionFee, BigDecimal issuedInCash,
                   BigDecimal bankTransfer, BigDecimal autoRepair,
                   BigDecimal selfResponsibility, BigDecimal otherNegative,
                   BigDecimal bankTransferFromBolt, BigDecimal bankTransferFromCarRenter,
                   BigDecimal frsRsk, BigDecimal cashFromRenter, BigDecimal bonusFrs,
                   BigDecimal bonusBolt, BigDecimal discount, BigDecimal otherPositive,
                   String comment) {
        this.id = id;
        this.driverId = driverId;
        this.callSign = callSign;
        this.driverCompany = driverCompany;
        this.driverCompanyRegNumber = driverCompanyRegNumber;
        this.driverCompanyAddress = driverCompanyAddress;
        this.firmId = firmId;
        this.firmName = firmName;
        this.regNumber = regNumber;
        this.vatNumber = vatNumber;
        this.iban = iban;
        this.bank = bank;
        this.invoiceNumber = invoiceNumber;
        this.weekNumber = weekNumber;
        this.dateCreation = dateCreation;
        this.dateStamp = dateStamp;
        this.rent = rent;
        this.frsConnectionFee = frsConnectionFee;
        this.issuedInCash = issuedInCash;
        this.bankTransfer = bankTransfer;
        this.autoRepair = autoRepair;
        this.selfResponsibility = selfResponsibility;
        this.otherNegative = otherNegative;
        this.bankTransferFromBolt = bankTransferFromBolt;
        this.bankTransferFromCarRenter = bankTransferFromCarRenter;
        this.frsRsk = frsRsk;
        this.cashFromRenter = cashFromRenter;
        this.bonusFrs = bonusFrs;
        this.bonusBolt = bonusBolt;
        this.discount = discount;
        this.otherPositive = otherPositive;
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
