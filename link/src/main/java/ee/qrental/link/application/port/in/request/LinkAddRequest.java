package ee.qrental.link.application.port.in.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class LinkAddRequest {
    private Long carId;
    private Long driverId;
    private String linkType;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateStart = LocalDate.now();
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateEnd;
    private String comment;
    private List<String> violations = new ArrayList<>();

    public boolean hasViolations() {
        return !violations.isEmpty();
    }
}

