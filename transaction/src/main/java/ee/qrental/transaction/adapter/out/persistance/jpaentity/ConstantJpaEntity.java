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
@Table(name = "constant")
public class ConstantJpaEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "constant")
    private String name;

    @Column(name = "value")
    private Double value;
    @Column(name = "negative")
    private Boolean negative;

    @Column(name = "description")
    private String description;


}
