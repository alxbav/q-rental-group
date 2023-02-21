package ee.qrental.transaction.adapter.out.persistance;

import ee.qrental.transaction.adapter.out.persistance.mapper.TransactionMapper;
import ee.qrental.transaction.adapter.out.persistance.repostories.SpringDataTransactionRepository;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Component
public class TransactionLoadAdapter implements TransactionLoadPort {

    private final SpringDataTransactionRepository springDataTransactionRepository;
    private final TransactionMapper mapper;

    @Override
    public Transaction loadById(final Long id) {
        return mapper.mapToDomain(springDataTransactionRepository.getReferenceById(id));
    }

    @Override
    public List<Transaction> loadAll() {
        return springDataTransactionRepository.findAll()
                .stream()
                .map(mapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public List<Transaction> loadAllByDriverId(final Long driverId) {
        return springDataTransactionRepository.findByDriverId(driverId)
                .stream()
                .map(mapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public List<Transaction> loadAllBetweenDays(
            final LocalDate dateStart, final LocalDate dateEnd) {
        return springDataTransactionRepository.findAllByDateBetween(dateStart, dateEnd)
                .stream()
                .map(mapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public List<Transaction> loadAllByDriverIdAndBetweenDays(
            final Long driverId, final LocalDate dateStart, final LocalDate dateEnd) {
        return springDataTransactionRepository
                .findAllByDateBetweenAndDriverId(dateStart, dateEnd, driverId)
                .stream()
                .map(mapper::mapToDomain)
                .collect(toList());
    }
}
