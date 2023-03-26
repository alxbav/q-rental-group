package ee.qrental.transaction.adapter.out.persistance.adapter;


import ee.qrental.transaction.adapter.out.persistance.mapper.InvoiceMapper;
import ee.qrental.transaction.adapter.out.persistance.repostories.SpringDataInvoiceRepository;
import ee.qrental.transaction.application.port.out.InvoiceAddPort;
import ee.qrental.transaction.application.port.out.InvoiceDeletePort;
import ee.qrental.transaction.application.port.out.InvoiceUpdatePort;
import ee.qrental.transaction.domain.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InvoicePersistenceAdapter
        implements InvoiceAddPort,
        InvoiceUpdatePort,
        InvoiceDeletePort {

    private final SpringDataInvoiceRepository springRepository;
    private final InvoiceMapper mapper;

    @Override
    public Invoice add(final Invoice invoice) {
        return mapper.mapToDomain(
                springRepository.save(
                        mapper.mapToEntity(invoice)
                ));
    }

    @Override
    public Invoice update(final Invoice invoice) {
        return mapper.mapToDomain(
                springRepository.save(
                        mapper.mapToEntity(invoice)
                ));
    }

    @Override
    public void delete(Long id) {
        springRepository.deleteById(id);
    }
}
