package ee.qrental.common.core.api.port;

public interface UpdatePort<D> {
    D update(D domain);
}
