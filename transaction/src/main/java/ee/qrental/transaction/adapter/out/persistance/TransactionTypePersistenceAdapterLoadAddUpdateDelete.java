package ee.qrental.transaction.adapter.out.persistance;

import ee.qrental.transaction.adapter.out.persistance.mapper.TransactionTypeMapper;
import ee.qrental.transaction.adapter.out.persistance.repostories.SpringDataTransactionTypeRepository;
import ee.qrental.transaction.application.port.out.TransactionTypeAddPort;
import ee.qrental.transaction.application.port.out.TransactionTypeDeletePort;
import ee.qrental.transaction.application.port.out.TransactionTypeLoadPort;
import ee.qrental.transaction.application.port.out.TransactionTypeUpdatePort;
import ee.qrental.transaction.domain.TransactionType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class TransactionTypePersistenceAdapterLoadAddUpdateDelete implements
        TransactionTypeLoadPort,
        TransactionTypeAddPort,
        TransactionTypeUpdatePort,
        TransactionTypeDeletePort {

    private final SpringDataTransactionTypeRepository springDataTransactionTypeRepository;
    private final TransactionTypeMapper transactionTypeMapper;

    @Override
    public List<TransactionType> loadAllTransactionTypes() {
        return springDataTransactionTypeRepository.findAll()
                .stream()
                .map(transactionTypeMapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public TransactionType loadTransactionTypeById(Long id) {
        return transactionTypeMapper.mapToDomain(
                springDataTransactionTypeRepository.getReferenceById(id));
    }

    @Override
    public TransactionType addTransactionType(final TransactionType transactionType) {
        return transactionTypeMapper.mapToDomain(
                springDataTransactionTypeRepository.save(
                        transactionTypeMapper.mapToEntity(transactionType)
                ));
    }

    @Override
    public TransactionType updateTransactionType(final TransactionType transactionType) {
        return transactionTypeMapper.mapToDomain(
                springDataTransactionTypeRepository.save(
                        transactionTypeMapper.mapToEntity(transactionType)
                ));
    }

    @Override
    public void deleteTransactionType(Long id) {
        springDataTransactionTypeRepository.deleteById(id);
    }
}