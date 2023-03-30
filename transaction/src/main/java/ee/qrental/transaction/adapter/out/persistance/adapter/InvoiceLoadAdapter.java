package ee.qrental.transaction.adapter.out.persistance.adapter;


import ee.qrental.transaction.adapter.out.persistance.mapper.InvoiceMapper;
import ee.qrental.transaction.adapter.out.persistance.repostories.SpringDataInvoiceRepository;
import ee.qrental.transaction.application.port.out.InvoiceLoadPort;
import ee.qrental.transaction.domain.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class InvoiceLoadAdapter
        implements InvoiceLoadPort {

    private final SpringDataInvoiceRepository springRepository;
    private final InvoiceMapper mapper;

    @Override
    public List<Invoice> loadAll() {
        return springRepository.findAll()
                .stream()
                .map(mapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public Invoice loadById(Long id) {
        return mapper.mapToDomain(
                springRepository.getReferenceById(id));
    }



}
