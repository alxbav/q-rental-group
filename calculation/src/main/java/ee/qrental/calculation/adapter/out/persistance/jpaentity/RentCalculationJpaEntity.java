package ee.qrental.calculation.adapter.out.persistance.jpaentity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "rent_calculation")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RentCalculationJpaEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "action_date")
    private LocalDate actionDate;

    @Column(name = "comment")
    private String comment;

    @OneToMany(mappedBy = "calculation")
    private List<RentCalculationResultJpaEntity> results;
}
