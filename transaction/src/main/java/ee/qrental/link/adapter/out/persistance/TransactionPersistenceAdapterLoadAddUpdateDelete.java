package ee.qrental.link.adapter.out.persistance;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ee.qrental.link.application.port.out.TransactionAddPort;
import ee.qrental.link.application.port.out.TransactionDeletePort;
import ee.qrental.link.application.port.out.TransactionLoadPort;
import ee.qrental.link.application.port.out.TransactionUpdatePort;
import ee.qrental.link.domain.Transaction;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class TransactionPersistenceAdapterLoadAddUpdateDelete implements
        TransactionLoadPort,
        TransactionAddPort,
        TransactionUpdatePort,
        TransactionDeletePort {

    private final SpringDataTransactionRepository springDataTransactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public List<Transaction> loadAllTransactions() {
        return springDataTransactionRepository.findAll()
                .stream()
                .map(transactionMapper::mapToDomain)
                .collect(toList());
    }

       @Override
    public Transaction loadTransactionById(Long id) {
        return transactionMapper.mapToDomain(
                springDataTransactionRepository.getReferenceById(id));
    }

    @Override
    public Transaction addTransaction(final Transaction transaction) {
        return transactionMapper.mapToDomain(
                springDataTransactionRepository.save(
                        transactionMapper.mapToEntity(transaction)
                ));
    }

    @Override
    public Transaction updateTransaction(final Transaction transaction) {
        return transactionMapper.mapToDomain(
                springDataTransactionRepository.save(
                        transactionMapper.mapToEntity(transaction)
                ));
    }

    @Override
    public void deleteTransaction(Long id) {
        springDataTransactionRepository.deleteById(id);
    }
}
