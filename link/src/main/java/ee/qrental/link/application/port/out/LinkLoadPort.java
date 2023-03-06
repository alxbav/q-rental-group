package ee.qrental.link.application.port.out;

import ee.qrental.link.domain.Link;

import java.time.LocalDate;
import java.util.List;

public interface LinkLoadPort {
    List<Link> loadAll();

    Link loadById(Long id);

    List<Link> loadByDateEndGreaterThan(final LocalDate date);

    List<Link> loadByDateEndIsNull();
}
