package ee.qrental.callsignlink.adapter.out.persistance.jpaentity;

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
@Table(name = "call_sign")
public class CallSignJpaEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "call_sign")
    private Integer callSign;

    @Column(name = "comment")
    private String comment;

    @OneToMany(mappedBy = "callSign")
    private Set<CallSignLinkJpaEntity> links;
}
