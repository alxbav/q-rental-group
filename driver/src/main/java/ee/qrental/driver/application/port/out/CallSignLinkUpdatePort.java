package ee.qrental.driver.application.port.out;

import ee.qrental.driver.domain.CallSignLink;


public interface CallSignLinkUpdatePort {
    CallSignLink updateCallSignLink(CallSignLink callSignLink);
}
