package ee.qrental.common.ui.controller.transaction;


import ee.qrental.transaction.application.port.in.query.GetTransactionTypeQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/transaction-types")
public class TransactionTypeQueryController {

    private final GetTransactionTypeQuery transactionTypeQuery;

    @GetMapping()
    public String getTransactionTypeView(final Model model) {
        model.addAttribute("transactionTypes", transactionTypeQuery.getAll());
        return "transactionTypes";
    }
}