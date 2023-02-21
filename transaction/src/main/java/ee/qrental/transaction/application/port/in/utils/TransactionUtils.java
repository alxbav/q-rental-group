package ee.qrental.transaction.application.port.in.utils;

import ee.qrental.transaction.application.port.in.response.transaction.TransactionResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class TransactionUtils {
    public static final Long getSum(final List<TransactionResponse> transactionResponses){
        return transactionResponses.stream()
                .mapToLong(transactionResponse-> transactionResponse.getRealAmount())
                .sum();
    }
}
