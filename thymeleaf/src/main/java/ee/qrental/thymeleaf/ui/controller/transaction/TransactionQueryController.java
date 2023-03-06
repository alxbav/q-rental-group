package ee.qrental.thymeleaf.ui.controller.transaction;


import ee.qrental.transaction.application.port.in.query.GetTransactionQuery;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionFilterRequest;
import ee.qrental.transaction.application.port.in.response.transaction.TransactionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static ee.qrental.thymeleaf.ui.controller.transaction.TransactionFilterRequestUtils.addCleanFilterRequestToModel;
import static ee.qrental.thymeleaf.ui.controller.transaction.TransactionFilterRequestUtils.addFilterOptionsToModel;

@AllArgsConstructor
@Controller
@RequestMapping("/transactions")
public class TransactionQueryController {
    private final GetTransactionQuery transactionQuery;

    @GetMapping
    public String getPageWithAllTransactions(final Model model) {
        addCleanFilterRequestToModel(model);
        addFilterOptionsToModel(model);
        addTransactionDataToModel(transactionQuery.getAll(), model);

        return "transactions";
    }

    @PostMapping
    public String getPageWithFilteredTransactions(
            @ModelAttribute final TransactionFilterRequest filterRequest,
            final Model model) {
        addFilterOptionsToModel(model);
        addTransactionDataToModel(transactionQuery.getAllByFilterRequest(filterRequest), model);

        return "transactions";
    }

    private void addTransactionDataToModel(final List<TransactionResponse> transactions, final Model model) {
        model.addAttribute("transactions", transactions);
    }
}