package ee.qrental.common.ui.controller;

import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.transaction.application.port.in.query.GetBalanceQuery;
import ee.qrental.transaction.application.port.in.query.GetTransactionQuery;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionFilterRequest;
import ee.qrental.transaction.application.port.in.utils.Week;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ee.qrental.transaction.application.port.in.utils.TransactionUtils.getSum;
import static java.lang.String.format;

@AllArgsConstructor
@Controller
@RequestMapping("/balances")
public class BalanceController {

    private final GetBalanceQuery balanceQuery;
    private final GetTransactionQuery transactionQuery;
    //TODO change to GetDriverQuery when available;
    private final DriverLoadPort driverLoadPort;

    @GetMapping
    public String getBalanceView(final Model model) {
        model.addAttribute("balances", balanceQuery.getAll());
        return "balances";
    }

    @GetMapping(value = "/driver/{id}")
    public String getDriverTransactionsView(
            @PathVariable("id") long id, final Model model) {
        final var filterRequest = new TransactionFilterRequest();
        filterRequest.setDriverId(id);
        model.addAttribute("filterRequest", filterRequest);
        model.addAttribute("driverId", id);
        model.addAttribute("years", List.of(2023));
        model.addAttribute("weeks", Week.values());
        final var transactions = transactionQuery.getAllByDriverId(id);
        model.addAttribute("transactions", transactions);
        model.addAttribute("viewTotal", getSum(transactions));
        model.addAttribute("total", balanceQuery.getTotalByDriverId(id));
        final var driver = driverLoadPort.loadById(id);
        model.addAttribute("driverInfo", format("%s %s", driver.getFirstName(), driver.getLastName()));

        return "detailView/balanceDriver";
    }

    @PostMapping(value = "/driver/{id}")
    public String getFilteredDriverTransactionsView(
            @PathVariable("id") long id,
            @ModelAttribute final TransactionFilterRequest filterRequest,
            final Model model) {
        model.addAttribute("filterRequest", new TransactionFilterRequest());
        model.addAttribute("driverId", id);
        model.addAttribute("years", List.of(2023));
        model.addAttribute("weeks", Week.values());
        final var transactions = transactionQuery.getAllByFilterRequest(filterRequest);
        model.addAttribute("transactions", transactions);
        model.addAttribute("viewTotal", getSum(transactions));
        model.addAttribute("total", balanceQuery.getTotalByDriverId(filterRequest.getDriverId()));
        final var driver = driverLoadPort.loadById(id);
        model.addAttribute("driverInfo", format("%s %s", driver.getFirstName(), driver.getLastName()));

        return "detailView/balanceDriver";
    }
}