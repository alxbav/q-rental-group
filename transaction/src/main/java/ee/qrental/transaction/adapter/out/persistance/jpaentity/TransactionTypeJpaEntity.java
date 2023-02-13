package ee.qrental.transaction.adapter.out.persistance.jpaentity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "transaction_type")
public class TransactionTypeJpaEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "type_tr")
    private String typeTr;

    @Column(name = "description")
    private String description;
    @Column(name = "negative")
    private Boolean negative;

    @Column(name = "comment")
    private String comment;

    @OneToMany(mappedBy = "type")
    private Set<TransactionJpaEntity> transactions;
}
