package ee.qrental.callsignlink.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CallSign {
    private Long id;
    private Integer callSign;
    private String comment;
}
