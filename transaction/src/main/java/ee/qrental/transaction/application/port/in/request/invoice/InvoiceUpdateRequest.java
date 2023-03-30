package ee.qrental.transaction.application.port.in.request.invoice;

import ee.qrental.common.core.api.application.request.AbstractUpdateRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class InvoiceUpdateRequest
        extends AbstractUpdateRequest {

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
}