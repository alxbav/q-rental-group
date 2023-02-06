package ee.qrental.transaction.adapter.out.persistance;

import ee.qrental.transaction.adapter.out.persistance.mapper.TransactionMapper;
import ee.qrental.transaction.adapter.out.persistance.repostories.SpringDataTransactionRepository;
import ee.qrental.transaction.application.port.out.TransactionAddPort;
import ee.qrental.transaction.application.port.out.TransactionDeletePort;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.application.port.out.TransactionUpdatePort;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

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
