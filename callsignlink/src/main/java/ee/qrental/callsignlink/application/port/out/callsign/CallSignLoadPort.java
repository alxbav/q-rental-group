package ee.qrental.callsignlink.application.port.out.callsign;

import ee.qrental.callsignlink.domain.CallSign;
import ee.qrental.common.core.api.port.LoadPort;


public interface CallSignLoadPort extends LoadPort<CallSign> {
    CallSign loadByCallSign(final Integer callSign);
}