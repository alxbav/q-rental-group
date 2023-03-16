package ee.qrental.transaction.application.port.in.utils;

import ee.qrental.transaction.application.port.in.response.transaction.TransactionResponse;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.List;

@UtilityClass
public class TransactionUtils {
    public static BigDecimal getSum(final List<TransactionResponse> transactionResponses){
        return transactionResponses
                .stream()
                .map(TransactionResponse::getRealAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
