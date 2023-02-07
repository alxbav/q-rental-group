package ee.qrental.driver.application.port.out;

import ee.qrental.driver.domain.CallSignLink;
import ee.qrental.driver.domain.Driver;

import java.util.List;
import java.util.Optional;

public interface CallSignLinkLoadPort {
    List<CallSignLink> loadAllCallSignLinks();

}
