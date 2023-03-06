package ee.qrental.job.adapter.out.persistance.jpaentity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "job")
public class JobJpaEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;


    @Column(name = "comment")
    private String comment;
}
