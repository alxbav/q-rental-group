package ee.qrental.link.application.port.in.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor


public class TransactionAddCommand {
    private String typeTr;
    private Integer transactionTypeId;
    private Integer driverId;
    private Long amount;
    private Integer weekNumber;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;
    private String comment;

}

