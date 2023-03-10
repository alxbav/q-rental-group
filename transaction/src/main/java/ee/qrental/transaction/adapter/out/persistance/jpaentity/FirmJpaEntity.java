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
@Table(name = "firm")
public class FirmJpaEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "firm_name")
    private String name;

    @Column(name = "iban")
    private String iban;
    @Column(name = "reg_number")
    private Long regNumber;
    @Column(name = "vat_number")
    private String vatNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "post_address")
    private String postAddress;
    @Column(name = " phone")
    private String phone;
    @Column(name = " bank")
    private String bank;
    @Column(name = "comment")
    private String comment;

}
