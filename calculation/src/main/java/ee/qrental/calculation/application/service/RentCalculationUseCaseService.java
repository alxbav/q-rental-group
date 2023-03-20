package ee.qrental.calculation.application.service;

import ee.qrental.calculation.application.port.in.mapper.RentCalculationAddRequestMapper;
import ee.qrental.calculation.application.port.in.request.RentCalculationAddRequest;
import ee.qrental.calculation.application.port.in.usecase.RentCalculationAddUseCase;
import ee.qrental.calculation.application.port.out.RentCalculationAddPort;
import ee.qrental.calculation.application.port.out.RentCalculationLoadPort;
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
import java.util.Optional;

import static ee.qrental.common.core.utils.QTimeUtils.getLastSundayFromDate;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

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


    @Override
    public Long add(RentCalculationAddRequest request) {
        final var domain = addRequestMapper.toDomain(request);
        final var actionDateFormal = getLastSundayFromDate(domain.getActionDate());
        final var map = linkQuery.getAll()
                .stream()
                .collect(toMap(identity(),
                        link -> rentCalculationLoadPort.
                                loadLastCalculationFromDateByLinkId(link.getDateStart(), link.getId())));
        final var rentCalculationResults = map.entrySet().stream()
                .filter(entry -> linkStartsBeforActionDate(entry.getKey(), actionDateFormal))
                .filter(entry -> linkIsNotClosedAndFullyCalculated(entry.getKey(), entry.getValue()))
                .map(entry -> getRentCalculationResults(entry.getKey(), entry.getValue(), actionDateFormal))
                .flatMap(Collection::stream)
                .collect(toList());
        final var rentCalculation = getRentCalculation(actionDateFormal, rentCalculationResults);

        return rentCalculationAddPort.add(rentCalculation).getId();
    }


    private boolean linkStartsBeforActionDate(
            final LinkResponse link,
            final LocalDate actionDate) {
        return link.getDateStart().isBefore(actionDate);
    }

    private boolean linkIsNotClosedAndFullyCalculated(
            final LinkResponse link,
            final Optional<RentCalculation> latestCalculation) {
        //if the link is started after latest Sunday from past
        if (latestCalculation.isEmpty()) {
            return true;
        }
        if (link.getDateEnd().isAfter(latestCalculation.get().getActionDate())) {
            return true;
        }
        return false;
    }

    private List<RentCalculationResult> getRentCalculationResults(
            final LinkResponse linkResponse,
            final Optional<RentCalculation> latestRentCalculation,
            final LocalDate actionDateFormal) {

        final var transactionAddRequests =
                linkToTransactionConverter.toTransactionAddRequests(
                        linkResponse, latestRentCalculation, actionDateFormal);

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
