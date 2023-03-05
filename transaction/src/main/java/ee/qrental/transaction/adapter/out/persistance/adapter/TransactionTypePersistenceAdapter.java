package ee.qrental.transaction.adapter.out.persistance.adapter;

import ee.qrental.transaction.adapter.out.persistance.mapper.TransactionTypeMapper;
import ee.qrental.transaction.adapter.out.persistance.repostories.SpringDataTransactionTypeRepository;
import ee.qrental.transaction.application.port.out.TransactionTypeAddPort;
import ee.qrental.transaction.application.port.out.TransactionTypeDeletePort;
import ee.qrental.transaction.application.port.out.TransactionTypeUpdatePort;
import ee.qrental.transaction.domain.TransactionType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionTypePersistenceAdapter implements
        TransactionTypeAddPort,
        TransactionTypeUpdatePort,
        TransactionTypeDeletePort {

    private final SpringDataTransactionTypeRepository springRepository;
    private final TransactionTypeMapper mapper;

    @Override
    public TransactionType add(final TransactionType transactionType) {
        return mapper.mapToDomain(
                springRepository.save(
                        mapper.mapToEntity(transactionType)
                ));
    }

    @Override
    public TransactionType update(final TransactionType transactionType) {
        return mapper.mapToDomain(
                springRepository.save(
                        mapper.mapToEntity(transactionType)
                ));
    }

    @Override
    public void delete(Long id) {
        springRepository.deleteById(id);
    }
}
