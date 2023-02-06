package ee.qrental.common.ui.controller;


import ee.qrental.transaction.application.port.in.command.TransactionTypeAddCommand;
import ee.qrental.transaction.application.port.in.command.TransactionTypeUpdateCommand;
import ee.qrental.transaction.application.port.in.usecase.TransactionTypeAddUseCase;
import ee.qrental.transaction.application.port.in.usecase.TransactionTypeDeleteUseCase;
import ee.qrental.transaction.application.port.in.usecase.TransactionTypeUpdateUseCase;
import ee.qrental.transaction.application.port.out.TransactionTypeLoadPort;
import ee.qrental.transaction.domain.TransactionType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor

@Controller
@RequestMapping("/transaction-types")
public class TransactionTypeController {

    private final TransactionTypeAddUseCase transactionTypeAddUseCase;
    private final TransactionTypeUpdateUseCase transactionTypeUpdateUseCase;
    private final TransactionTypeLoadPort transactionTypeLoadPort;
    private final TransactionTypeDeleteUseCase transactionTypeDeleteUseCase;

    @GetMapping()
    public String getTransactionTypeView(final Model model) {
        addTransactionTypeListToModel(model);
        return "transactionTypes";
    }

    private void  addTransactionTypeListToModel(final Model model) {
        final var transactionTypes = transactionTypeLoadPort.loadAllTransactionTypes();
        model.addAttribute("transactionTypes", transactionTypes);
    }

    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        model.addAttribute("transactionTypeAddCommand", new TransactionTypeAddCommand());
        return "addFormTransactionType";
    }

    @PostMapping(value = "/add")
    public String addTransactionTransactionType(@ModelAttribute final TransactionTypeAddCommand transactionTypeInfo) {
        transactionTypeAddUseCase.add(transactionTypeInfo);
        return "redirect:/transaction-types";
    }


    @GetMapping(value = "/update-form/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        final var transactionTypeUpdateCommand = mapToCommand(transactionTypeLoadPort.loadTransactionTypeById(id));
        model.addAttribute("transactionTypeUpdateCommand", transactionTypeUpdateCommand);
        return "updateFormTransactionType";
    }

    @PostMapping("/update")
    public String updateTransactionTransactionType(
            final TransactionTypeUpdateCommand transactionTypeUpdateCommand) {
        transactionTypeUpdateUseCase.update(transactionTypeUpdateCommand);
        return "redirect:/transaction-types";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") long id) {
        transactionTypeDeleteUseCase.delete(id);
        return "redirect:/transaction-types";
    }

    private TransactionTypeUpdateCommand mapToCommand(final TransactionType domain) {
        final var result = new TransactionTypeUpdateCommand();
        result.setId(domain.getId());
        result.setName(domain.getName());
        result.setDescription(domain.getDescription());
        result.setComment(domain.getComment());
        return result;
    }
}