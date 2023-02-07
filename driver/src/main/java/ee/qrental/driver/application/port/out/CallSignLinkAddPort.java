package ee.qrental.driver.application.port.out;

import ee.qrental.driver.domain.CallSignLink;
import ee.qrental.driver.domain.Driver;

public interface CallSignLinkAddPort {
    CallSignLink addCallSignLink(CallSignLink callSignLink);
}
