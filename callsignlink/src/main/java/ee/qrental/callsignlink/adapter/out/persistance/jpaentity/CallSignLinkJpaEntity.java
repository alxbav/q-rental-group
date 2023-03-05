package ee.qrental.callsignlink.adapter.out.persistance.jpaentity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "call_sign_link")
public class CallSignLinkJpaEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="call_sign_id")
    private CallSignJpaEntity callSign;

    @Column(name = "driver_id")
    private Long driverId;

    @Column(name = "date_start")
    private LocalDate dateStart;

    @Column(name = "date_end")
    private LocalDate dateEnd;

    @Column(name = "comment")
    private String comment;
}
