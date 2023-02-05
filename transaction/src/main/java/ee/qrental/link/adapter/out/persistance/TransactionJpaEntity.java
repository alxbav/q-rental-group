package ee.qrental.link.adapter.out.persistance;

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
@Table(name = "transaction")
public class TransactionJpaEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "transaction_type_id")
    private Integer transactionTypeId;

    @Column(name = "driver_id")
    private Integer driverId;


    @Column(name = "amount")
    private Long amount;

    @Column(name = "week_number")
    private Integer weekNumber;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "comment")
    private String comment;
}
