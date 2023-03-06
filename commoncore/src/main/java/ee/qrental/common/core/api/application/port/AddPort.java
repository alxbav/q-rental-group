package ee.qrental.common.core.api.application.port;

public interface AddPort<D> {
    D add(D domain);
}
