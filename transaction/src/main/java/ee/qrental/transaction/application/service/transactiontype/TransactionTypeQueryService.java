package ee.qrental.transaction.application.service.transactiontype;

import ee.qrental.transaction.application.port.in.mapper.transaciontype.TransactionTypeResponseMapper;
import ee.qrental.transaction.application.port.in.mapper.transaciontype.TransactionTypeUpdateRequestMapper;
import ee.qrental.transaction.application.port.in.query.GetTransactionTypeQuery;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionTypeUpdateRequest;
import ee.qrental.transaction.application.port.in.response.transactiontype.TransactionTypeResponse;
import ee.qrental.transaction.application.port.out.TransactionTypeLoadPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class TransactionTypeQueryService
        implements GetTransactionTypeQuery {

    private final TransactionTypeLoadPort loadPort;
    private final TransactionTypeResponseMapper mapper;
    private final TransactionTypeUpdateRequestMapper updateRequestMapper;

    @Override
    public List<TransactionTypeResponse> getAll() {
        return loadPort.loadAll()
                .stream()
                .map(mapper::toResponse)
                .collect(toList());
    }

    @Override
    public TransactionTypeResponse getById(final Long id) {
        return mapper.toResponse(loadPort.loadById(id));
    }

    @Override
    public String getObjectInfo(Long id) {
        return mapper.toObjectInfo(loadPort.loadById(id));
    }

    @Override
    public TransactionTypeUpdateRequest getUpdateRequestById(Long id) {
        return updateRequestMapper.toRequest(loadPort.loadById(id));
    }

    @Override
    public TransactionTypeResponse getByName(final String name) {
        return mapper.toResponse(loadPort.loadByName(name));
    }

    @Override
    public List<TransactionTypeResponse> getNegative() {
        return loadPort.loadByNegative(TRUE)
                .stream()
                .map(mapper::toResponse)
                .collect(toList());
    }

    @Override
    public List<TransactionTypeResponse> getPositive() {
        return loadPort.loadByNegative(FALSE)
                .stream()
                .map(mapper::toResponse)
                .collect(toList());
    }
}
