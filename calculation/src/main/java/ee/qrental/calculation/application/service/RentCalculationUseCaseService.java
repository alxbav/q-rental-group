package ee.qrental.calculation.application.service;

import ee.qrental.calculation.application.port.in.mapper.RentCalculationAddRequestMapper;
import ee.qrental.calculation.application.port.in.request.RentCalculationAddRequest;
import ee.qrental.calculation.application.port.in.usecase.RentCalculationAddUseCase;
import ee.qrental.calculation.application.port.out.RentCalculationAddPort;
import ee.qrental.calculation.application.port.out.RentCalculationLoadPort;
import ee.qrental.calculation.application.validator.RentCalculationBusinessRuleValidator;
import ee.qrental.calculation.domain.RentCalculation;
import ee.qrental.calculation.domain.RentCalculationResult;
import ee.qrental.link.application.port.in.query.GetLinkQuery;
import ee.qrental.link.application.port.in.response.LinkResponse;
import ee.qrental.transaction.application.port.in.usecase.transaction.TransactionAddUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static ee.qrental.common.core.utils.QTimeUtils.getLastSundayFromDate;
import static java.util.stream.Collectors.toList;

@Service

@AllArgsConstructor
public class RentCalculationUseCaseService
        implements RentCalculationAddUseCase {

    private final GetLinkQuery linkQuery;
    private final TransactionAddUseCase transactionAddusecase;
    private final RentCalculationAddPort rentCalculationAddPort;
    private final RentCalculationLoadPort rentCalculationLoadPort;
    private final LinkToTransactionConverter linkToTransactionConverter;
    private final RentCalculationAddRequestMapper addRequestMapper;
    private final RentCalculationBusinessRuleValidator businessRuleValidator;

    @Override
    public Long add(RentCalculationAddRequest request) {
        final var domain = addRequestMapper.toDomain(request);
        final var violationsCollector = businessRuleValidator.validate(domain);
        if (violationsCollector.hasViolations()) {
            request.setViolations(violationsCollector.getViolations());

            return null;
        }
        final var actionDateFormal = getLastSundayFromDate(domain.getActionDate());
        final var lastCalculationDate = rentCalculationLoadPort.loadLastCalculation().getActionDate();
        final var rentCalculationResults = linkQuery.getActiveLinks()
                .stream()
                .map(link -> getRentCalculationResults(link, lastCalculationDate, actionDateFormal))
                .flatMap(Collection::stream)
                .collect(toList());

        final var rentCalculation = getRentCalculation(actionDateFormal, rentCalculationResults);

        return rentCalculationAddPort.add(rentCalculation).getId();
    }

    private List<RentCalculationResult> getRentCalculationResults(
            final LinkResponse linkResponse,
            final LocalDate lastCalculationDate,
            final LocalDate actionDate) {
        final var transactionAddRequests =
                linkToTransactionConverter.toTransactionAddRequests(
                        linkResponse, lastCalculationDate, actionDate);

        return transactionAddRequests.stream()
                .map(transactionAddusecase::add)
                .map(transactionId -> getRentCalculationResult(
                        transactionId,
                        linkResponse.getId()))
                .collect(toList());
    }

    private RentCalculationResult getRentCalculationResult(
            final Long transactionId,
            final Long linkId) {
        final var result = new RentCalculationResult();
        result.setTransactionId(transactionId);
        result.setLinkId(linkId);

        return result;
    }

    private RentCalculation getRentCalculation(
            final LocalDate actionDate,
            final List<RentCalculationResult> results) {
        final var rentCalculation = new RentCalculation();
        rentCalculation.setActionDate(actionDate);
        rentCalculation.setResults(results);

        return rentCalculation;
    }
}
