package ee.qrental.link.application.port.out;

import ee.qrental.link.domain.Link;

import java.util.List;

public interface LinkLoadPort {
    List<Link> loadAllLinks();

    Link loadLinkById(Long id);
}