package ee.qrental.transaction.application.port.in.mapper;

import ee.qrental.common.core.api.mapper.ResponseMapper;
import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionUpdateRequest;
import ee.qrental.transaction.application.port.in.response.transaction.TransactionResponse;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;

import static java.lang.String.format;

@AllArgsConstructor
public class TransactionResponseMapper
        implements ResponseMapper<TransactionUpdateRequest, TransactionResponse, Transaction> {

    private final DriverLoadPort driverLoadPort;

    @Override
    public TransactionResponse toResponse(final Transaction domain) {
        var driver = driverLoadPort.loadById(domain.getDriverId());
        var driverInfo = driver.getFirstName() + " " + driver.getLastName();
        return TransactionResponse.builder()
                .id(domain.getId())
                .realAmount(domain.getRealAmount())
                .type(domain.getType().getName())
                .driverInfo(driverInfo)
                .date(domain.getDate())
                .weekNumber(domain.getWeekNumber())
                .comment(domain.getComment())
                .build();
    }

    @Override
    public String toObjectInfo(Transaction domain) {
        final var driver = driverLoadPort.loadById(domain.getDriverId());
        final var type = domain.getType().getName();
        final var realAmount = domain.getRealAmount();
        final var date = domain.getDate().toString();
        final var weekNumber = domain.getWeekNumber();
        final var driverInfo = driver.getFirstName() + " " + driver.getLastName();

        return format("Transaction: %s %d EURO, week number: %d (%s), for driver: %s",
                type,
                realAmount,
                weekNumber,
                date,
                driverInfo);
    }

    @Override
    public TransactionUpdateRequest toUpdateRequest(Transaction domain) {
        final var request = new TransactionUpdateRequest();
        request.setId(domain.getId());
        request.setTransactionTypeId(domain.getType().getId());
        request.setAmount(domain.getAmount());
        request.setDriverId(domain.getDriverId());
        request.setDate(domain.getDate());
        request.setComment(domain.getComment());

        return request;
    }
}