package ee.qrental.calculation.adapter.out.persistance;

import ee.qrental.calculation.adapter.out.persistance.mapper.RentCalculationMapper;
import ee.qrental.calculation.adapter.out.persistance.repository.SpringDataRentCalculationRepository;
import ee.qrental.calculation.application.port.out.RentCalculationLoadPort;
import ee.qrental.calculation.domain.RentCalculation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component

@AllArgsConstructor
public class RentCalculationLoadAdapter
        implements RentCalculationLoadPort {

    private final SpringDataRentCalculationRepository calculationRepository;
    private final RentCalculationMapper mapper;

    @Override
    public List<RentCalculation> loadAll() {
        return calculationRepository.findAll()
                .stream()
                .map(mapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public RentCalculation loadById(Long id) {
        return mapper.mapToDomain(
                calculationRepository.getReferenceById(id));
    }

    @Override
    public RentCalculation loadLastCalculation() {
        return mapper.mapToDomain(
                calculationRepository.findTopByOrderByActionDateDesc());
    }
}