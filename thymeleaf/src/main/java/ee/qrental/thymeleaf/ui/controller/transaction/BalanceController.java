package ee.qrental.thymeleaf.ui.controller.transaction;

import ee.qrental.driver.application.port.in.query.GetDriverQuery;
import ee.qrental.transaction.application.port.in.query.GetBalanceQuery;
import ee.qrental.transaction.application.port.in.query.GetTransactionQuery;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionFilterRequest;
import ee.qrental.transaction.application.port.in.response.transaction.TransactionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ee.qrental.transaction.application.port.in.utils.TransactionUtils.getSum;


@Controller
@RequestMapping("/balances")

@AllArgsConstructor
public class BalanceController {

    private final GetBalanceQuery balanceQuery;
    private final GetTransactionQuery transactionQuery;
    private final GetDriverQuery driverQuery;

    @GetMapping
    public String getBalanceView(final Model model) {
        model.addAttribute("balances", balanceQuery.getAll());
        return "balances";
    }

    @GetMapping(value = "/driver/{id}")
    public String getDriverTransactionsView(
            @PathVariable("id") long id,
            final Model model) {
        TransactionFilterRequestUtils.addCleanFilterRequestToModel(id, model);
        TransactionFilterRequestUtils.addFilterOptionsToModel(model);
        addTransactionDataToModel(transactionQuery.getAllByDriverId(id), model);
        addDriverDataToModel(id, model);

        return "detailView/balanceDriver";
    }

    @PostMapping(value = "/driver/{id}")
    public String getFilteredDriverTransactionsView(
            @PathVariable("id") long id,
            @ModelAttribute final TransactionFilterRequest transactionFilterRequest,
            final Model model) {
        TransactionFilterRequestUtils.addFilterOptionsToModel(model);
        addTransactionDataToModel(transactionQuery.getAllByFilterRequest(transactionFilterRequest), model);
        addDriverDataToModel(id, model);

        return "detailView/balanceDriver";
    }

    private void addTransactionDataToModel(final List<TransactionResponse> transactions, final Model model) {
        model.addAttribute("transactions", transactions);
        model.addAttribute("viewTotal", getSum(transactions));
    }

    private void addDriverDataToModel(final Long driverId, final Model model) {
        model.addAttribute("driverId", driverId);
        model.addAttribute("total", balanceQuery.getTotalByDriverId(driverId));
        model.addAttribute("driverInfo", driverQuery.getObjectInfo(driverId));
    }
}