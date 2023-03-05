package ee.qrental.transaction.adapter.out.persistance.adapter;

import ee.qrental.transaction.adapter.out.persistance.mapper.TransactionMapper;
import ee.qrental.transaction.adapter.out.persistance.repostories.SpringDataTransactionRepository;
import ee.qrental.transaction.application.port.out.TransactionAddPort;
import ee.qrental.transaction.application.port.out.TransactionDeletePort;
import ee.qrental.transaction.application.port.out.TransactionUpdatePort;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionPersistenceAdapter implements
        TransactionAddPort,
        TransactionUpdatePort,
        TransactionDeletePort {

    private final SpringDataTransactionRepository springRepository;
    private final TransactionMapper mapper;

    @Override
    public Transaction add(final Transaction transaction) {
        return mapper.mapToDomain(
                springRepository.save(
                        mapper.mapToEntity(transaction)
                ));
    }

    @Override
    public Transaction update(final Transaction transaction) {
        return mapper.mapToDomain(
                springRepository.save(
                        mapper.mapToEntity(transaction)
                ));
    }

    @Override
    public void delete(Long id) {
        springRepository.deleteById(id);
    }



}
