package ee.qrental.transaction.application.service.invoice;

import ee.qrental.transaction.application.port.in.mapper.invoice.InvoiceResponseMapper;
import ee.qrental.transaction.application.port.in.mapper.invoice.InvoiceUpdateRequestMapper;
import ee.qrental.transaction.application.port.in.query.GetInvoiceQuery;
import ee.qrental.transaction.application.port.in.request.invoice.InvoiceUpdateRequest;
import ee.qrental.transaction.application.port.in.response.invoice.InvoiceResponse;
import ee.qrental.transaction.application.port.out.InvoiceLoadPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class InvoiceQueryService
        implements GetInvoiceQuery {

    private final InvoiceLoadPort loadPort;
    private final InvoiceResponseMapper mapper;
    private final InvoiceUpdateRequestMapper updateRequestMapper;

    @Override
    public List<InvoiceResponse> getAll() {
        return loadPort.loadAll()
                .stream()
                .map(mapper::toResponse)
                .collect(toList());
    }


 /*   @Override
    public InvoiceResponse getById(final Long id) {
        return mapper.toResponse(loadPort.loadById(id));
    }

    @Override
    public String getObjectInfo(Long id) {
        return mapper.toObjectInfo(loadPort.loadById(id));
    }

    @Override
    public InvoiceUpdateRequest getUpdateRequestById(Long id) {
        return updateRequestMapper.toRequest(loadPort.loadById(id));
    }
    */


}
