package ee.qrental.transaction.adapter.out.persistance.adapter;

import ee.qrental.transaction.adapter.out.persistance.mapper.TransactionTypeMapper;
import ee.qrental.transaction.adapter.out.persistance.repostories.SpringDataTransactionTypeRepository;
import ee.qrental.transaction.application.port.out.TransactionTypeLoadPort;
import ee.qrental.transaction.domain.TransactionType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class TransactionTypeLoadAdapter implements
        TransactionTypeLoadPort {

    private final SpringDataTransactionTypeRepository springRepository;
    private final TransactionTypeMapper mapper;

    @Override
    public List<TransactionType> loadAll() {
        return springRepository.findAll()
                .stream()
                .map(mapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public TransactionType loadById(Long id) {
        return mapper.mapToDomain(
                springRepository.getReferenceById(id));
    }

    @Override
    public TransactionType loadByName(String name) {
        return mapper.mapToDomain(
                springRepository.findByName(name));
    }
}
