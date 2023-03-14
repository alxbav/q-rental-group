package ee.qrental.thymeleaf.ui.controller.calculation;


import ee.qrental.calculation.application.port.in.query.GetRentCalculationQuery;
import ee.qrental.transaction.application.port.in.query.GetTransactionQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/calculations")

@AllArgsConstructor
public class RentCalculationQueryController {

    private final GetRentCalculationQuery rentCalculationQuery;
    private final GetTransactionQuery transactionQuery;

    @GetMapping
    public String getCalculationView(final Model model) {
        model.addAttribute("calculations", rentCalculationQuery.getAll());

        return "calculations";
    }

    @GetMapping(value = "/transactions/{id}")
    public String getCalculationTransactionsView(@PathVariable("id") long id, final Model model) {
        model.addAttribute("transactions", transactionQuery.getAllByCalculationId(id));
        model.addAttribute("calculationInfo", rentCalculationQuery.getObjectInfo(id));

        return "detailView/calculationTransactions";
    }
}