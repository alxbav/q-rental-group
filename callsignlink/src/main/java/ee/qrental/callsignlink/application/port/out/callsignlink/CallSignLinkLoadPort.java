package ee.qrental.callsignlink.application.port.out.callsignlink;

import ee.qrental.callsignlink.domain.CallSignLink;
import ee.qrental.common.core.api.application.port.LoadPort;

import java.util.List;

public interface CallSignLinkLoadPort
        extends LoadPort<CallSignLink> {

    List<CallSignLink> loadActiveCallSignLinks();
}
