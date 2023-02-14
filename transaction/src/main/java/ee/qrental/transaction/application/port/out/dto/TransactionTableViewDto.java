package ee.qrental.transaction.application.port.out.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
public class TransactionTableViewDto {
    private Long id;
    private String type;
    private String driver;
    private Long amount;
    private Integer weekNumber;
    private LocalDate date;
    private String comment;
}
