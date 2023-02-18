package ee.qrental.common.ui.controller.transaction;


import ee.qrental.transaction.application.port.in.query.GetTransactionTypeQuery;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionTypeAddRequest;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionTypeDeleteRequest;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionTypeUpdateRequest;
import ee.qrental.transaction.application.port.in.usecase.transactiontype.TransactionTypeAddUseCase;
import ee.qrental.transaction.application.port.in.usecase.transactiontype.TransactionTypeDeleteUseCase;
import ee.qrental.transaction.application.port.in.usecase.transactiontype.TransactionTypeUpdateUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/transaction-types")
public class TransactionTypeUseCaseController {

    private final TransactionTypeAddUseCase addUseCase;
    private final TransactionTypeUpdateUseCase updateUseCase;
    private final TransactionTypeDeleteUseCase deleteUseCase;

    private final GetTransactionTypeQuery transactionTypeQuery;

    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        model.addAttribute("addRequest", new TransactionTypeAddRequest());

        return "forms/addTransactionType";
    }

    @PostMapping(value = "/add")
    public String addTransactionTransactionType(
            @ModelAttribute final TransactionTypeAddRequest transactionTypeInfo) {
        addUseCase.add(transactionTypeInfo);

        return "redirect:/transaction-types";
    }

    @GetMapping(value = "/update-form/{id}")
    public String updateForm(@PathVariable("id") long id, final Model model) {
        model.addAttribute("updateRequest", transactionTypeQuery.getUpdateRequestById(id));

        return "forms/updateTransactionType";
    }

    @PostMapping("/update")
    public String updateTransactionTransactionType(
            final TransactionTypeUpdateRequest transactionTypeUpdateRequest) {
        updateUseCase.update(transactionTypeUpdateRequest);

        return "redirect:/transaction-types";
    }

    @GetMapping(value = "/delete-form/{id}")
    public String deleteForm(@PathVariable("id") long id, final Model model) {
        model.addAttribute("deleteRequest", new TransactionTypeDeleteRequest(id));
        model.addAttribute("objectInfo", transactionTypeQuery.getObjectInfo(id));

        return "forms/deleteTransactionType";
    }

    @PostMapping("/delete")
    public String deleteForm(final TransactionTypeDeleteRequest deleteRequest) {
        deleteUseCase.delete(deleteRequest);

        return "redirect:/transaction-types";
    }
}