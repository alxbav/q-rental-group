package ee.qrental.job.application.service;


import ee.qrental.link.application.port.in.query.GetLinkQuery;
import ee.qrental.link.application.port.in.response.LinkResponse;
import ee.qrental.transaction.application.port.in.query.GetTransactionTypeQuery;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionAddRequest;
import ee.qrental.transaction.application.port.in.usecase.transaction.TransactionAddUseCase;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class RentCalculationJob {

    private final static String RENT_TRANSACTION_TYPE = "Renting payment";
    private final GetLinkQuery linkQuery;
    private final TransactionAddUseCase transactionAddUseCase;
    private final GetTransactionTypeQuery transactionTypeQuery;

    @Scheduled(fixedRate = 5000)
    public void calculateRentTransactions() {
        linkQuery.getActiveLinks()
                .stream()
                .map(this::calculateTransaction)
                .forEach(transaction -> transactionAddUseCase.add(transaction));
    }

    private TransactionAddRequest calculateTransaction(final LinkResponse linkResponse) {
        final var transaction = new TransactionAddRequest();
        final var driverId = linkResponse.getDriverId();
        transaction.setDriverId(driverId);
        transaction.setDate(LocalDate.now());
        transaction.setTransactionTypeId(getRentTransactionTypeId());
        transaction.setAmount(getAmount(linkResponse));
        transaction.setComment("Automatically created, based on link ID = " + linkResponse.getId());

        return transaction;
    }

    private Long getRentTransactionTypeId() {
        return transactionTypeQuery.getByName(RENT_TRANSACTION_TYPE).getId();
    }

    private Long getAmount(final LinkResponse linkResponse) {
        //TODO add Car Service
        return 100L;
    }

}
