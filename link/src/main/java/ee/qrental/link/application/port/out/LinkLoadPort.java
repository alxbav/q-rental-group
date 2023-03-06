package ee.qrental.link.application.port.out;

import ee.qrental.common.core.api.application.port.LoadPort;
import ee.qrental.link.domain.Link;

import java.time.LocalDate;
import java.util.List;

public interface LinkLoadPort
        extends LoadPort<Link> {

    List<Link> loadByDateEndGreaterThan(final LocalDate date);

    List<Link> loadByDateEndIsNull();
}
