package ee.qrental.common.core.api.port;

import java.util.List;

public interface LoadPort<T> {
    List<T> loadAll();

    T loadById(final Long id);
}
