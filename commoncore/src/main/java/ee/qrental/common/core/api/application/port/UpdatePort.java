package ee.qrental.common.core.api.application.port;

public interface UpdatePort<D> {
    D update(D domain);
}
