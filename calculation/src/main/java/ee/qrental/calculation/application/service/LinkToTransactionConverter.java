package ee.qrental.calculation.application.service;

import ee.qrental.calculation.application.service.strategy.RateCalculationStrategy;
import ee.qrental.common.core.utils.QTimeUtils;
import ee.qrental.link.application.port.in.response.LinkResponse;
import ee.qrental.transaction.application.port.in.query.GetTransactionTypeQuery;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionAddRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component

@AllArgsConstructor
public class LinkToTransactionConverter {
    private final static String RENT_TRANSACTION_TYPE_NAME = "rent_fee";
    private final GetTransactionTypeQuery transactionTypeQuery;
    private final List<RateCalculationStrategy> calculationStrategies;

    public List<TransactionAddRequest> toTransactionAddRequests(
            final LinkResponse linkResponse,
            final LocalDate lastCalculationDate,
            final LocalDate actionDate) {
        final var calculationStartDate = getCalculationStartDate(lastCalculationDate, linkResponse);
        final var calculationEndDate = getCalculationEndDate(actionDate, linkResponse);
        final var weekIterator = new QWeekIterator(calculationStartDate, calculationEndDate);
        final var transactionAddRequests = new ArrayList<TransactionAddRequest>();
        while (weekIterator.hasNext()) {
            final var week = weekIterator.next();
            final var weekTotal = calculationStrategies.stream()
                    .filter(rateCalculationStrategy -> rateCalculationStrategy.canApply(week))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No matching Week Calculation Strategy was found"))
                    .calculate(week);
            final var transactionDate = week.end();
            final var transactionAddRequest = new TransactionAddRequest();
            transactionAddRequest.setDriverId(linkResponse.getDriverId());
            transactionAddRequest.setDate(transactionDate);
            transactionAddRequest.setTransactionTypeId(getTransactionTypeId());
            transactionAddRequest.setAmount(weekTotal);
            transactionAddRequest.setComment(String.format(
                    "Automatically created, based on link ID: %d for week: %d",
                    linkResponse.getId(),
                    QTimeUtils.getWeekNumber(transactionDate)));
            transactionAddRequests.add(transactionAddRequest);
        }

        return transactionAddRequests;
    }

    private Long getTransactionTypeId() {
        return transactionTypeQuery
                .getByName(RENT_TRANSACTION_TYPE_NAME)
                .getId();
    }

    private LocalDate getCalculationStartDate(
            final LocalDate lastCalculationDate,
            final LinkResponse linkResponse) {
        final var linkDateStart = linkResponse.getDateStart();
        if (linkDateStart.isBefore(lastCalculationDate)) {

            return lastCalculationDate;
        }
        if (linkDateStart.isAfter(lastCalculationDate)) {

            return linkDateStart;
        }
        throw new RuntimeException("Invalid Link Start date. Start date can't be in future");
    }

    private LocalDate getCalculationEndDate(
            final LocalDate actionDate,
            final LinkResponse linkResponse) {
        if (linkResponse.getDateEnd() == null || linkResponse.getDateEnd().isAfter(actionDate)) {

            return actionDate;
        }

        return linkResponse.getDateEnd();
    }
}
