package ee.qrental.transaction.adapter.out.persistance;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ee.qrental.transaction.application.port.out.TransactionAddPort;
import ee.qrental.transaction.application.port.out.TransactionDeletePort;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.application.port.out.TransactionUpdatePort;
import ee.qrental.transaction.domain.Transaction;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class TransactionPersistenceAdapterLoadAddUpdateDelete implements
        TransactionLoadPort,
        TransactionAddPort,
        TransactionUpdatePort,
        TransactionDeletePort {

    private final SpringDataTransactionRepository springDataTransactionTypeRepository;
    private final TransactionMapper transactionTypeMapper;

    @Override
    public List<Transaction> loadAllTransactionTypes() {
        return springDataTransactionTypeRepository.findAll()
                .stream()
                .map(transactionTypeMapper::mapToDomain)
                .collect(toList());
    }

       @Override
    public Transaction loadTransactionTypeById(Long id) {
        return transactionTypeMapper.mapToDomain(
                springDataTransactionTypeRepository.getReferenceById(id));
    }

    @Override
    public Transaction addTransactionType(final Transaction transactionType) {
        return transactionTypeMapper.mapToDomain(
                springDataTransactionTypeRepository.save(
                        transactionTypeMapper.mapToEntity(transactionType)
                ));
    }

    @Override
    public Transaction updateTransactionType(final Transaction transactionType) {
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
