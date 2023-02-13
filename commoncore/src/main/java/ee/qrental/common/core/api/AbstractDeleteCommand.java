package ee.qrental.common.core.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public abstract class AbstractDeleteCommand {
    private Long id;

    private String objectInfo;

}
