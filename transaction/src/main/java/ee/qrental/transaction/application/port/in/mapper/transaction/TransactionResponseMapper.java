package ee.qrental.transaction.application.port.in.mapper.transaction;

import ee.qrental.callsignlink.application.port.in.query.GetCallSignLinkQuery;
import ee.qrental.common.core.api.application.mapper.ResponseMapper;
import ee.qrental.transaction.application.port.in.response.transaction.TransactionResponse;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component

@AllArgsConstructor
public class TransactionResponseMapper
        implements ResponseMapper<TransactionResponse, Transaction> {

    private final GetCallSignLinkQuery callSignLinkQuery;

    @Override
    public TransactionResponse toResponse(final Transaction domain) {
        final var callSignLinkResponse = callSignLinkQuery.getCallSignLinkByDriverId(
                domain.getDriverId());

        return TransactionResponse.builder()
                .id(domain.getId())
                .realAmount(domain.getRealAmount())
                .type(domain.getType().getName())
                .driverInfo(callSignLinkResponse.getDriverInfo())
                .callSign(callSignLinkResponse.getCallSign())
                .date(domain.getDate())
                .weekNumber(domain.getWeekNumber())
                .comment(domain.getComment())
                .dateStamp(domain.getDateStamp())
                .build();
    }

    @Override
    public String toObjectInfo(Transaction domain) {
        final var type = domain.getType().getName();
        final var realAmount = domain.getRealAmount();
        final var date = domain.getDate().toString();
        final var weekNumber = domain.getWeekNumber();
        final var callSignLinkResponse = callSignLinkQuery.getCallSignLinkByDriverId(
                domain.getDriverId());

        return format("Transaction: %s %d EURO, " +
                        "week number: %d (%s), " +
                        "for driver: %s " +
                        "with call sign: %d",
                type,
                realAmount,
                weekNumber,
                date,
                callSignLinkResponse.getDriverInfo(),
                callSignLinkResponse.getCallSign());
    }
}