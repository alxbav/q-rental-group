package ee.qrental.common.ui.controller;


import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.transaction.application.port.in.command.TransactionAddCommand;
import ee.qrental.transaction.application.port.in.command.TransactionUpdateCommand;
import ee.qrental.transaction.application.port.in.usecase.TransactionAddUseCase;
import ee.qrental.transaction.application.port.in.usecase.TransactionDeleteUseCase;
import ee.qrental.transaction.application.port.in.usecase.TransactionUpdateUseCase;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.application.port.out.TransactionTypeLoadPort;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionAddUseCase transactionAddUseCase;
    private final TransactionUpdateUseCase transactionUpdateUseCase;
    private final TransactionLoadPort transactionLoadPort;
    private final TransactionDeleteUseCase transactionDeleteUseCase;
    private final TransactionTypeLoadPort transactionTypeLoadPort;

    private final DriverLoadPort driverLoadPort;

    @GetMapping
    public String getTransactionView(final Model model) {
        addTransactionListToModel(model);
        addTransactionTypeListToModel(model);
        return "transactions";
    }

    private void addTransactionListToModel(final Model model) {
        final var transactions = transactionLoadPort.loadAllTransactions();
        model.addAttribute("transactions", transactions);
    }

    private void addTransactionTypeListToModel(final Model model) {
        final var transactionTypes = transactionTypeLoadPort.loadAllTransactionTypes();
        model.addAttribute("transactionTypes", transactionTypes);
    }

    private void addDriverListToModel(final Model model) {
        final var drivers = driverLoadPort.loadAllDrivers();
        model.addAttribute("drivers", drivers);
    }

    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        model.addAttribute("transactionAddCommand", new TransactionAddCommand());
        addTransactionTypeListToModel(model);
        addDriverListToModel(model);
        return "addFormTransaction";
    }

    @PostMapping(value = "/add")
    public String addTransactionTransaction(@ModelAttribute final TransactionAddCommand transactionInfo) {
        transactionAddUseCase.add(transactionInfo);
        return "redirect:/transactions";
    }

    @GetMapping(value = "/update-form/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        final var transactionUpdateCommand = mapToCommand(transactionLoadPort.loadTransactionById(id));
        model.addAttribute("transactionUpdateCommand", transactionUpdateCommand);
        addTransactionTypeListToModel(model);
        addDriverListToModel(model);
        return "updateFormTransaction";
    }

    @PostMapping("/update")
    public String updateTransactionTransaction(final TransactionUpdateCommand transactionUpdateCommand) {
        transactionUpdateUseCase.update(transactionUpdateCommand);
        return "redirect:/transactions";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") long id) {
        transactionDeleteUseCase.delete(id);
        return "redirect:/transactions";
    }

    private TransactionUpdateCommand mapToCommand(final Transaction domain) {
        final var result = new TransactionUpdateCommand();
        result.setId(domain.getId());
        result.setTransactionTypeId(domain.getType().getId());
        result.setDriverId(domain.getDriverId());
        result.setAmount(domain.getAmount());
        result.setWeekNumber(domain.getWeekNumber());
        result.setDate(domain.getDate());
        result.setComment(domain.getComment());
        return result;
    }


}