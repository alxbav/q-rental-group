package ee.qrental.common.ui.controller;

import ee.qrental.transaction.application.port.in.query.GetBalanceQuery;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionWeekAndDriverFilterRequest;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionWeekFilterRequest;
import ee.qrental.transaction.application.port.in.utils.Week;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/balances")
public class BalanceController {

    private final GetBalanceQuery balanceQuery;

    @GetMapping
    public String getBalanceView(final Model model) {
        model.addAttribute("balances", balanceQuery.getAll());
        return "balances";
    }

    @GetMapping(value = "/driver/{id}")
    public String getDriverBalanceDetailView(
            @PathVariable("id") long id, final Model model) {
        final var searchRequest = new TransactionWeekAndDriverFilterRequest();
        searchRequest.setDriverId(id);
        model.addAttribute("searchRequest", searchRequest);
        model.addAttribute("years", List.of(2023));
        model.addAttribute("weeks", Week.values());

        final var driverBalance = balanceQuery.getDetailedBalanceByDriverId(id);
        model.addAttribute("driverBalance", driverBalance);

        return "detailView/balanceDriver";
    }

    @PostMapping(value = "/driver/{id}")
    public String getFiltyeredDriverBalanceDetailView(
            @ModelAttribute final TransactionWeekAndDriverFilterRequest searchRequest,
            final Model model) {
        model.addAttribute("transactions", balanceQuery.getDetailedBalanceBySearchRequest(searchRequest));
        model.addAttribute("searchRequest", new TransactionWeekFilterRequest());
        model.addAttribute("years", List.of(2023));
        model.addAttribute("weeks", Week.values());

        return "transactions";
    }
}