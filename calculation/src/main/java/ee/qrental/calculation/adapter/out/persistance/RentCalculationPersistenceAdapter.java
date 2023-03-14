package ee.qrental.calculation.adapter.out.persistance;

import ee.qrental.calculation.adapter.out.persistance.mapper.RentCalculationMapper;
import ee.qrental.calculation.adapter.out.persistance.mapper.RentCalculationResultMapper;
import ee.qrental.calculation.adapter.out.persistance.repository.SpringDataRentCalculationRepository;
import ee.qrental.calculation.adapter.out.persistance.repository.SpringDataRentCalculationResultRepository;
import ee.qrental.calculation.application.port.out.RentCalculationAddPort;
import ee.qrental.calculation.domain.RentCalculation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;

@Component

@AllArgsConstructor
public class RentCalculationPersistenceAdapter
        implements RentCalculationAddPort {

    private final SpringDataRentCalculationRepository rentCalculationRepository;
    private final SpringDataRentCalculationResultRepository rentCalculationResultRepository;
    private final RentCalculationMapper calculationMapper;
    private final RentCalculationResultMapper calculationResultMapper;

    @Override
    public RentCalculation add(RentCalculation domain) {
        final var savedRentCalculationEntity = rentCalculationRepository.save(
                calculationMapper.mapToEntity(domain));
        final var resultEntities = domain.getResults().stream()
                .map(calculationResultMapper::mapToEntity)
                .peek(entity -> entity.setCalculation(savedRentCalculationEntity))
                .collect(toList());
        final var savedRentCalculationResultEntities = rentCalculationResultRepository.saveAll(resultEntities);
        savedRentCalculationEntity.setResults(savedRentCalculationResultEntities);

        return calculationMapper.mapToDomain(savedRentCalculationEntity);
    }
}