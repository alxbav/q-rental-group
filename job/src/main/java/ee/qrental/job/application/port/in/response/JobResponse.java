package ee.qrental.job.application.port.in.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class JobResponse {
    private Long id;
    private String name;
    private String comment;
}
