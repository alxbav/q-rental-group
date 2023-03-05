package ee.qrental.callsignlink.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static java.lang.String.format;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CallSignLink {
    private Long id;
    private Long callSignId;
    private Long driverId;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String comment;
}
