package ee.qrental.common.ui.controller.transaction;


import ee.qrental.transaction.application.port.in.query.GetTransactionQuery;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionFilterRequest;
import ee.qrental.transaction.application.port.in.utils.Week;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/transactions")
public class TransactionQueryController {
    private final GetTransactionQuery transactionQuery;

    @GetMapping
    public String getPageWithAllTransactions(final Model model) {
        model.addAttribute("searchRequest", new TransactionFilterRequest());
        model.addAttribute("years", List.of(2023));
        model.addAttribute("weeks", Week.values());
        model.addAttribute("transactions", transactionQuery.getAll());

        return "transactions";
    }

    @PostMapping
    public String getPageWithFilteredTransactions(
            @ModelAttribute final TransactionFilterRequest searchRequest,
            final Model model) {
        model.addAttribute("transactions", transactionQuery.getAllByRequest(searchRequest));
        model.addAttribute("searchRequest", new TransactionFilterRequest());
        model.addAttribute("years", List.of(2023));
        model.addAttribute("weeks", Week.values());

        return "transactions";
    }
}