package ee.qrental.thymeleaf.ui.controller.transaction;

import ee.qrental.transaction.application.port.in.request.transaction.TransactionFilterRequest;
import ee.qrental.transaction.application.port.in.utils.Week;
import lombok.experimental.UtilityClass;
import org.springframework.ui.Model;

import java.util.List;

@UtilityClass
public class TransactionFilterRequestUtils {

    static void addFilterOptionsToModel(final Model model) {
        model.addAttribute("years", List.of(2023));
        model.addAttribute("weeks", Week.values());
    }

    static void addCleanFilterRequestToModel(final Long driverId, final Model model) {
        final var transactionFilterRequest = new TransactionFilterRequest();
        transactionFilterRequest.setDriverId(driverId);
        model.addAttribute("transactionFilterRequest", transactionFilterRequest);
    }

    static void addCleanFilterRequestToModel(final Model model) {
        final var transactionFilterRequest = new TransactionFilterRequest();
        model.addAttribute("transactionFilterRequest", transactionFilterRequest);
    }

}
